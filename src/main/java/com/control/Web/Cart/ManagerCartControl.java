package com.control.Web.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.entity.Cart;
import com.entity.Product;
import com.service.ICartService;
import com.service.IProductService;
import com.service.impl.CartService;
import com.service.impl.ProductService;

@WebServlet(urlPatterns = {"/managerCart"})
public class ManagerCartControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICartService crt = new CartService();
	IProductService prod = new ProductService();

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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        int accountID = a.getId();
        
                List<Cart> list = crt.getCartByAccountID(accountID);
        List<Product> list2 = prod.getAllProduct();
        double totalMoney=0;
        for(Cart o : list) {
        	for(Product p : list2) {
        		if(o.getProductID()==p.getId()) {
        			totalMoney=totalMoney+(p.getPrice()*o.getAmount());
        		}
        	}
        }
         
        
        request.setAttribute("listCart", list);
        request.setAttribute("listProduct", list2);
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("VAT", totalMoney*0.1);
        
        double totalMoneyVAT=totalMoney+totalMoney*0.1; 
        request.setAttribute("totalMoneyVAT", totalMoneyVAT);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);

        
    }
}
