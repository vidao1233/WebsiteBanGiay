package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Account;
import com.entity.Invoice;
import com.service.IAccountService;
import com.service.IInvoiceService;
import com.service.impl.AccountService;
import com.service.impl.InvoiceService;

@WebServlet(urlPatterns = {"/searchAjaxHoaDon"})
public class SearchByAjaxHoaDon extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAccountService acc = new AccountService();
	IInvoiceService inv = new InvoiceService();

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
        String ngayXuat = request.getParameter("ngayXuat");
        
        List<Invoice> listInvoiceByDate = inv.searchByNgayXuat(ngayXuat);
        List<Account> listAllAccount = acc.getAllAccount();
        PrintWriter out = response.getWriter(); 
        double tongGia;
        for (Invoice o : listInvoiceByDate) {
        	for (Account a : listAllAccount) {
        		if(o.getAccountID() == a.getId()) {	
        			tongGia=Math.round((o.getTongGia()) * 100.0) / 100.0;
        	out.println("<tr>\r\n"
        			+ "                  <th scope=\"row\"></th>\r\n"
        			+ "                  <td>"+o.getMaHD()+"</td>\r\n"
        			+ "                  <td>"+a.getUser()+"</td>\r\n"
        			+ "                  <td>"+tongGia+"</td>\r\n"
        			+ "                  <td>"+o.getNgayXuat()+"</td> \r\n"
        			+ "                </tr>");
        		}
        		}
        }
        
        
    }
}
