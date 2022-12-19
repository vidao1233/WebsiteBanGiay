package com.control.Admin.DoanhThu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IInvoiceService;
import com.service.impl.InvoiceService;

@WebServlet(urlPatterns = {"/doanhThuTheoThu"})
public class DoanhThuTheoThuControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
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
      
        double totalMoney1 = inv.totalMoneyDay(1);
        double totalMoney2 = inv.totalMoneyDay(2);
        double totalMoney3 = inv.totalMoneyDay(3);
        double totalMoney4 = inv.totalMoneyDay(4);
        double totalMoney5 = inv.totalMoneyDay(5);
        double totalMoney6 = inv.totalMoneyDay(6);
        double totalMoney7 = inv.totalMoneyDay(7);
        
        
        
        request.setAttribute("totalMoney1", totalMoney1);
        request.setAttribute("totalMoney2", totalMoney2);
        request.setAttribute("totalMoney3", totalMoney3);
        request.setAttribute("totalMoney4", totalMoney4);
        request.setAttribute("totalMoney5", totalMoney5);
        request.setAttribute("totalMoney6", totalMoney6);
        request.setAttribute("totalMoney7", totalMoney7);
        
    
        
        request.getRequestDispatcher("DoanhThuTheoThu.jsp").forward(request, response);
    }
}
