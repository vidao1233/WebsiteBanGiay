package com.control.Web.Order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.entity.Cart;
import com.entity.Email;
import com.entity.EmailUtils;
import com.entity.Product;
import com.entity.SoLuongDaBan;
import com.entity.TongChiTieuBanHang;
import com.service.ICartService;
import com.service.IInvoiceService;
import com.service.IProductService;
import com.service.ISoLuongDaBanService;
import com.service.ITongChiTieuBanHangService;
import com.service.impl.CartService;
import com.service.impl.InvoiceService;
import com.service.impl.ProductService;
import com.service.impl.SoLuongDaBanService;
import com.service.impl.TongChiTieuBanHangService;

@WebServlet(urlPatterns = {"/order"})
public class OrderControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICartService crt = new CartService();
	IProductService prod = new ProductService();
	ITongChiTieuBanHangService tong = new TongChiTieuBanHangService();
	ISoLuongDaBanService so = new SoLuongDaBanService();
	IInvoiceService inv = new InvoiceService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Account a = (Account) session.getAttribute("acc");
        if(a == null) {
        	resp.sendRedirect("login");
        	return;
        }
        int accountID = a.getId();
        List<Cart> list = crt.getCartByAccountID(accountID);
        List<Product> list2 = prod.getAllProduct();
        double totalMoney=0;
        for(Cart c : list) {
			for(Product p : list2) {
				if(c.getProductID()==p.getId()) {
					totalMoney=totalMoney+(p.getPrice()*c.getAmount());
				}
			}
		}
        double totalMoneyVAT=totalMoney+totalMoney*0.1;
        
        double tongTienBanHangThem=0;
        int sell_ID;
        for(Cart c : list) {
			for(Product p : list2) {
				if(c.getProductID()==p.getId()) {
					tongTienBanHangThem=0;
					sell_ID=prod.getSellIDByProductID(p.getId());
					tongTienBanHangThem=tongTienBanHangThem+(p.getPrice()*c.getAmount());
					TongChiTieuBanHang t2 = tong.checkTongChiTieuBanHangExist(accountID);
					if(t2==null) {
						tong.insertTongChiTieuBanHang(accountID,0,tongTienBanHangThem);
					}
					else {
						tong.editTongBanHang(sell_ID, tongTienBanHangThem);
					}	
				}
			}
		}
        
        
        for(Cart c : list) {
			for(Product p : list2) {
				if(c.getProductID()==p.getId()) {
					SoLuongDaBan s = so.checkSoLuongDaBanExist(p.getId());
					if(s == null) {
						so.insertSoLuongDaBan(p.getId(), c.getAmount());
					}
					else {
						so.editSoLuongDaBan(p.getId(), c.getAmount());
					}	
				}
			}
		}
        
        inv.insertInvoice(accountID, totalMoneyVAT);
        TongChiTieuBanHang t = tong.checkTongChiTieuBanHangExist(accountID);
        if(t==null) {
        	tong.insertTongChiTieuBanHang(accountID,totalMoneyVAT,0);
        }
        else {
        	tong.editTongChiTieu(accountID, totalMoneyVAT);
        }
        
        
	req.getRequestDispatcher("DatHang.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String emailAddress = req.getParameter("email");
			String name = req.getParameter("name");
			String phoneNumber = req.getParameter("phoneNumber");
			String deliveryAddress = req.getParameter("deliveryAddress");
			
			 HttpSession session = req.getSession();
		        Account a = (Account) session.getAttribute("acc");
		        if(a == null) {
		        	resp.sendRedirect("login");
		        	return;
		        }
		        int accountID = a.getId();
		        List<Cart> list = crt.getCartByAccountID(accountID);
		        List<Product> list2 = prod.getAllProduct();
					
		        double totalMoney=0;
		        for(Cart c : list) {
					for(Product p : list2) {
						if(c.getProductID()==p.getId()) {
							totalMoney=totalMoney+(p.getPrice()*c.getAmount());
						}
					}
				}
		        double totalMoneyVAT=totalMoney+totalMoney*0.1;
		        
		        
		        //old code
				Email email =new Email();
				email.setFrom("nna9220@gmail.com"); //chinh lai email quan tri tai day [chu y dung email con hoat dong]
				email.setFromPassword("wevzzoqyzuystafv"); //mat khau email tren
				email.setTo(emailAddress);
				email.setSubject("Dat hang thanh cong tu Shoes Family");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(name).append("<br>");
				sb.append("Ban vua dat dang tu Shoes Family. <br> ");
				sb.append("Dia chi nhan hang cua ban la: <b>").append(deliveryAddress).append(" </b> <br>");
				sb.append("So dien thoai khi nhan hang cua ban la: <b>").append(phoneNumber).append(" </b> <br>");
				sb.append("Cac san pham ban dat la: <br>");
				for(Cart c : list) {
					for(Product p : list2) {
						if(c.getProductID()==p.getId()) {
							sb.append(p.getName()).append(" | ").append("Price:").append(p.getPrice()).append("$").append(" | ").append("Amount:").append(c.getAmount()).append(" | ").append("Size:").append(c.getSize()).append("<br>");
						}
					}
				}
				sb.append("Tong Tien: ").append(String.format("%.02f",totalMoneyVAT)).append("$").append("<br>");
				sb.append("Cam on ban da dat hang tai Shoes Family<br>");
				sb.append("Chu cua hang");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				req.setAttribute("mess", "Dat hang thanh cong!");
				
				crt.deleteCartByAccountID(accountID);
				
				
				//new code
//				request.setAttribute("email", emailAddress);
//				request.getRequestDispatcher("ThongTinDatHang.jsp").forward(request, response);
				
			
		} catch (Exception e) {
			req.setAttribute("error", "Dat hang that bai!");
			e.printStackTrace();
		}
	
		req.getRequestDispatcher("DatHang.jsp").forward(req, resp);
	}

}
