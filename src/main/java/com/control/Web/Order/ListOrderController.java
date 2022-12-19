package com.control.Web.Order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.entity.Cart;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;
import com.service.IOrderItemService;
import com.service.IOrderService;
import com.service.IProductService;
import com.service.impl.OrderItemServiceImpl;
import com.service.impl.OrderServiceImpl;
import com.service.impl.ProductService;

@WebServlet(urlPatterns = { "/listOrder" })
public class ListOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IOrderService ords = new OrderServiceImpl();
	IOrderItemService ordIs = new OrderItemServiceImpl();
	IProductService prod = new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account a = (Account) session.getAttribute("acc");
		if (a == null) {
			resp.sendRedirect("login");
			return;
		}
		int user = a.getId();
		List<Product> list2 = prod.getAllProduct();
		List<Order> listOrd = ords.getByAccount(user);
		List<OrderItem> listOrdI = ordIs.getAll();
		
		req.setAttribute("oItemList", listOrdI);
		List<OrderItem> listOI = ordIs.getByOD(listOrdI.get(0).getId());
		List<Product> prods = prod.getByOItem(listOI.get(0).getProdID());
		/*
		 * for(OrderItem oi : list) { for(Product p : list2) {
		 * if(o.getProductID()==p.getId()) {
		 * totalMoney=totalMoney+(p.getPrice()*o.getAmount()); } } }
		 */
		req.setAttribute("listOI0", listOI.get(0).getCreateAt());

		req.setAttribute("prod", prods.get(0));
		
		req.setAttribute("listOI", listOI);
		req.setAttribute("listProd", list2);
		req.setAttribute("ordList", listOrd);
		RequestDispatcher dispatcher = req.getRequestDispatcher("ListOrderByAccount.jsp");
		dispatcher.forward(req, resp);
	}

}
