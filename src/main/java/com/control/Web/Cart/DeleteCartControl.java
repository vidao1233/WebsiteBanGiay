package com.control.Web.Cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ICartService;
import com.service.impl.CartService;

@WebServlet(urlPatterns = {"/deleteCart"})
public class DeleteCartControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICartService crt = new CartService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int productID = Integer.parseInt(req.getParameter("productID"));
        
        crt.deleteCart(productID);
        req.setAttribute("mess", "Da xoa san pham khoi gio hang!");
        req.getRequestDispatcher("managerCart").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
