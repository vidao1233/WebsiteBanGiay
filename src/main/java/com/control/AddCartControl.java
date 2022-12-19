package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.entity.Cart;
import com.service.ICartService;
import com.service.impl.CartService;

@WebServlet(urlPatterns = {"/addCart"})
public class AddCartControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICartService crt = new CartService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        int productID = Integer.parseInt(request.getParameter("pid"));
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        int accountID = a.getId();
        int amount = Integer.parseInt(request.getParameter("quantity"));
        String size = request.getParameter("size");
        
        Cart cartExisted = crt.checkCartExist(accountID,productID);
        int amountExisted;
        String sizeExisted;
        if(cartExisted != null) {
        	 amountExisted = cartExisted.getAmount();
        	 crt.editAmountAndSizeCart(accountID,productID, (amountExisted+amount), size);
        	 request.setAttribute("mess", "Da tang so luong san pham!");
        	 request.getRequestDispatcher("managerCart").forward(request, response);
        }
        else {
        	  crt.insertCart(accountID, productID, amount, size);
        	  request.setAttribute("mess", "Da them san pham vao gio hang!");
        	  request.getRequestDispatcher("managerCart").forward(request, response);
        }
      
    }
}
