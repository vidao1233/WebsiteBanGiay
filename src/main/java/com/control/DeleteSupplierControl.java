package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ISupplierService;
import com.service.impl.SupplierService;

@WebServlet(urlPatterns = {"/deleteSupplier"})
public class DeleteSupplierControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ISupplierService supp = new SupplierService();

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
        String idSupplier = request.getParameter("id");
        
        supp.deleteSupplier(idSupplier);
        request.setAttribute("mess", "Supplier Deleted!");
        request.getRequestDispatcher("managerSupplier").forward(request, response);
    }
}
