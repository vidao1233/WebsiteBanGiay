package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.entity.Invoice;
import com.service.IAccountService;
import com.service.IInvoiceService;
import com.service.IProductService;
import com.service.IReviewService;
import com.service.impl.AccountService;
import com.service.impl.InvoiceService;
import com.service.impl.ProductService;
import com.service.impl.ReviewService;

@WebServlet(urlPatterns = {"/admin"})
public class StatisticControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAccountService acc = new AccountService();
	IInvoiceService inv = new InvoiceService();
	IProductService prod = new ProductService();
	IReviewService rev = new ReviewService();

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
        int uID;
        
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        uID= a.getId();
 	   int checkIsAdmin = acc.checkAccountAdmin(uID);
       if(checkIsAdmin == 0)
       {
       		response.sendRedirect("login");
       		return;
       }
        	
        	
       
        double totalMoney1 = inv.totalMoneyDay(1);
        double totalMoney2 = inv.totalMoneyDay(2);
        double totalMoney3 = inv.totalMoneyDay(3);
        double totalMoney4 = inv.totalMoneyDay(4);
        double totalMoney5 = inv.totalMoneyDay(5);
        double totalMoney6 = inv.totalMoneyDay(6);
        double totalMoney7 = inv.totalMoneyDay(7);
        
        double totalMoneyMonth1 = inv.totalMoneyMonth(1);
        double totalMoneyMonth2 = inv.totalMoneyMonth(2);
        double totalMoneyMonth3 = inv.totalMoneyMonth(3);
        double totalMoneyMonth4 = inv.totalMoneyMonth(4);
        double totalMoneyMonth5 = inv.totalMoneyMonth(5);
        double totalMoneyMonth6 = inv.totalMoneyMonth(6);
        double totalMoneyMonth7 = inv.totalMoneyMonth(7);
        double totalMoneyMonth8 = inv.totalMoneyMonth(8);
        double totalMoneyMonth9 = inv.totalMoneyMonth(9);
        double totalMoneyMonth10 = inv.totalMoneyMonth(10);
        double totalMoneyMonth11 = inv.totalMoneyMonth(11);
        double totalMoneyMonth12 = inv.totalMoneyMonth(12);
        
        int allReview = rev.countAllReview();
        int allProduct = prod.countAllProduct();
        double sumAllInvoice = inv.sumAllInvoice();
        
        List<Invoice> listAllInvoice = inv.getAllInvoice();
        List<Account> listAllAccount = acc.getAllAccount();
        
        request.setAttribute("listAllInvoice", listAllInvoice);
        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("sumAllInvoice", sumAllInvoice);
        
        request.setAttribute("allReview", allReview);
        request.setAttribute("allProduct", allProduct);
        
        request.setAttribute("totalMoney1", totalMoney1);
        request.setAttribute("totalMoney2", totalMoney2);
        request.setAttribute("totalMoney3", totalMoney3);
        request.setAttribute("totalMoney4", totalMoney4);
        request.setAttribute("totalMoney5", totalMoney5);
        request.setAttribute("totalMoney6", totalMoney6);
        request.setAttribute("totalMoney7", totalMoney7);
        
        request.setAttribute("totalMoneyMonth1", totalMoneyMonth1);
        request.setAttribute("totalMoneyMonth2", totalMoneyMonth2);
        request.setAttribute("totalMoneyMonth3", totalMoneyMonth3);
        request.setAttribute("totalMoneyMonth4", totalMoneyMonth4);
        request.setAttribute("totalMoneyMonth5", totalMoneyMonth5);
        request.setAttribute("totalMoneyMonth6", totalMoneyMonth6);
        request.setAttribute("totalMoneyMonth7", totalMoneyMonth7);
        request.setAttribute("totalMoneyMonth8", totalMoneyMonth8);
        request.setAttribute("totalMoneyMonth9", totalMoneyMonth9);
        request.setAttribute("totalMoneyMonth10", totalMoneyMonth10);
        request.setAttribute("totalMoneyMonth11", totalMoneyMonth11);
        request.setAttribute("totalMoneyMonth12", totalMoneyMonth12);
        
       
    
        request.getRequestDispatcher("Statistic.jsp").forward(request, response);
      
       
       
    }
}
