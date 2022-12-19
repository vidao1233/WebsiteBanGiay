package com.control.Admin.DoanhThu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IInvoiceService;
import com.service.impl.InvoiceService;

@WebServlet(urlPatterns = {"/doanhThuTheoThang"})
public class DoanhThuTheoThangControl extends HttpServlet{

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
    
        request.getRequestDispatcher("DoanhThuTheoThang.jsp").forward(request, response);
    }
}
