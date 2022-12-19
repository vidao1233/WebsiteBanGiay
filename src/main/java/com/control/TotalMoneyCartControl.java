package com.control;

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

@WebServlet(urlPatterns = {"/totalMoneyCart"})
public class TotalMoneyCartControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IProductService prod = new ProductService();
	ICartService crt = new CartService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int accountID = a.getId();
        
        List<Cart> list = crt.getCartByAccountID(accountID);
        List<Product> list2 = prod.getAllProduct();
        
        double totalMoney=0;
        for(Cart o : list) {
        	for(Product p : list2) {
        		if(o.getProductID()==p.getId()) {
        			totalMoney=totalMoney+p.getPrice()*o.getAmount();
        		}
        	}
        }
        
        double totalMoneyVAT=totalMoney*0.9;
        totalMoneyVAT = Math.round(totalMoneyVAT);
        
        	
        PrintWriter out = response.getWriter();
        		out.println(" <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng tiền hàng</strong><strong>"+totalMoney+"</strong></li>\r\n"
        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Phí vận chuyển</strong><strong>Free ship</strong></li>\r\n"
        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>10 %</strong></li>\r\n"
        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng thanh toán</strong>\r\n"
        				+ "                                            <h5 class=\"font-weight-bold\">"+totalMoneyVAT+"</h5>\r\n"
        				+ "                                        </li>");     	
        
    }
}
