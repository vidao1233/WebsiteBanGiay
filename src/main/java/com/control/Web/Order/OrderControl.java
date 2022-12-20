package com.control.Web.Order;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.entity.Cart;
import com.entity.Delivery;
import com.entity.Email;
import com.entity.EmailUtils;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;
import com.entity.SoLuongDaBan;
import com.entity.TongChiTieuBanHang;
import com.service.ICartService;
import com.service.IInvoiceService;
import com.service.IOrderService;
import com.service.IProductService;
import com.service.ISoLuongDaBanService;
import com.service.ITongChiTieuBanHangService;
import com.service.impl.CartService;
import com.service.impl.InvoiceService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.ProductService;
import com.service.impl.SoLuongDaBanService;
import com.service.impl.TongChiTieuBanHangService;

@WebServlet(urlPatterns = { "/order" })
public class OrderControl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ICartService crt = new CartService();
	IProductService prod = new ProductService();
	ITongChiTieuBanHangService tong = new TongChiTieuBanHangService();
	ISoLuongDaBanService so = new SoLuongDaBanService();
	IInvoiceService inv = new InvoiceService();
	IOrderService ords = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			resp.sendRedirect("login");
			return;
		}
		int accountID = a.getId();
		List<Cart> list = crt.getCartByAccountID(accountID);
		List<Product> list2 = prod.getAllProduct();
		double totalMoney = 0;
		for (Cart c : list) {
			for (Product p : list2) {
				if (c.getProductID() == p.getId()) {
					totalMoney = totalMoney + (p.getPrice() * c.getAmount());
				}
			}
		}
		double totalMoneyVAT = totalMoney + totalMoney * 0.1;
		double tongTienBanHangThem = 0;
		int sell_ID;
		for (Cart c : list) {
			for (Product p : list2) {
				if (c.getProductID() == p.getId()) {
					tongTienBanHangThem = 0;
					sell_ID = prod.getSellIDByProductID(p.getId());
					tongTienBanHangThem = tongTienBanHangThem + (p.getPrice() * c.getAmount());
					TongChiTieuBanHang t2 = tong.checkTongChiTieuBanHangExist(accountID);
					if (t2 == null) {
						tong.insertTongChiTieuBanHang(accountID, 0, tongTienBanHangThem);
					} else {
						tong.editTongBanHang(sell_ID, tongTienBanHangThem);
					}
				}
			}
		}
		for (Cart c : list) {
			for (Product p : list2) {
				if (c.getProductID() == p.getId()) {
					SoLuongDaBan s = so.checkSoLuongDaBanExist(p.getId());
					if (s == null) {
						so.insertSoLuongDaBan(p.getId(), c.getAmount());
					} else {
						so.editSoLuongDaBan(p.getId(), c.getAmount());
					}
				}
			}
		}
		inv.insertInvoice(accountID, totalMoneyVAT);
		TongChiTieuBanHang t = tong.checkTongChiTieuBanHangExist(accountID);
		if (t == null) {
			tong.insertTongChiTieuBanHang(accountID, totalMoneyVAT, 0);
		} else {
			tong.editTongChiTieu(accountID, totalMoneyVAT);
		}
		List<Delivery> dels = ords.getAllDel();
		req.setAttribute("dels", dels);
		req.setAttribute("listCart", list);
		req.setAttribute("listProduct", list2);
		req.getRequestDispatcher("DatHang.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			Order ord = new Order();
			HttpSession session = req.getSession();
			Account a = (Account) session.getAttribute("acc");
			int accountID = a.getId();
			List<Cart> list = crt.getCartByAccountID(accountID);
			
			String email = req.getParameter("email");
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			String detail = req.getParameter("detail");
			String province = req.getParameter("province");
			String district = req.getParameter("district");
			String ward = req.getParameter("ward");
			String delivery = req.getParameter("delivery");
			String payment = "Tiền mặt";
			String uID = req.getParameter("uID");
			ord.setId(list.get(0).getMaCart());
			ord.setuID(Integer.parseInt(uID));
			ord.setStatus(0);
			ord.setPhone(phone); 
			ord.setPayment(payment); 
			ord.setDelivery(1);
			ord.setProvince(province); 
			ord.setDistrict(district); 
			ord.setWard(ward);
			ord.setName(name); 
			ord.setDetail(detail); 
			ords.insert(ord);
			System.out.println("Order: "+ ord.getId());

			List<Product> list2 = prod.getAllProduct();
			OrderItem ordI = new OrderItem();
			ordI.setOrdID(ord.getId());
			LocalDate test1 = LocalDate.now();
			ordI.setCreateAt(test1.toString());
			int count =0;
			double totalMoney = 0;
			for (Cart c : list) {
				for (Product p : list2) {
					if (c.getProductID() == p.getId()) {
						totalMoney = totalMoney + (p.getPrice() * c.getAmount());
						count++;
						ordI.setProdID(p.getId());
					}
				}

				ordI.setCount(count);
				ords.insertItem(ordI);
			}
			double totalMoneyVAT = totalMoney + totalMoney * 0.1;
			String address = detail + " " + ward + " " + district + " " + province;
			// old code
			Email emails = new Email();
			emails.setFrom("nna9220@gmail.com"); // chinh lai email quan tri tai day [chu y dung email con hoat dong]
			emails.setFromPassword("wevzzoqyzuystafv"); // mat khau email tren
			emails.setTo(email);
			emails.setSubject("Đặt hàng thành công tư Shoes Family");
			StringBuilder sb = new StringBuilder();
			sb.append("Dear ").append(name).append("<br>");
			sb.append("Bạn vừa đặt hàng. <br> ");
			sb.append("Địa chỉ nhận hàng: <b>").append(address).append(" </b> <br>");
			sb.append("Số điện thoại nhận hàng: <b>").append(phone).append(" </b> <br>");
			sb.append("Các sản phẩm đã đặt: <br>");
			for (Cart c : list) {
				for (Product p : list2) {
					if (c.getProductID() == p.getId()) {
						sb.append(p.getName()).append(" | ").append("Price:").append(p.getPrice()).append("$")
								.append(" | ").append("Amount:").append(c.getAmount()).append(" | ").append("Size:")
								.append(c.getSize()).append("<br>");
					}
				}
			}
			sb.append("Tong Tien: ").append(String.format("%.02f", totalMoneyVAT)).append("$").append("<br>");
			sb.append("Cam on ban da dat hang tai Shoes Family<br>");
			sb.append("Chu cua hang");

			emails.setContent(sb.toString());
			EmailUtils.send(emails);
			req.setAttribute("mess", "Dat hang thanh cong!");
			
			crt.deleteCartByAccountID(accountID);

			// new code
//				request.setAttribute("email", emailAddress);
//				request.getRequestDispatcher("ThongTinDatHang.jsp").forward(request, response);

		} catch (Exception e) {
			req.setAttribute("error", "Dat hang that bai!");
			e.printStackTrace();
		}

		req.getRequestDispatcher("DatHang.jsp").forward(req, resp);
	}

}
