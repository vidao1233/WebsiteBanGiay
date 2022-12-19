package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Category;
import com.entity.Supplier;
import com.service.ICategoryService;
import com.service.ISupplierService;
import com.service.impl.CategoryService;
import com.service.impl.SupplierService;

@WebServlet(urlPatterns = {"/managerSupplier"})
public class ManagerSupplierControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICategoryService cate = new CategoryService();
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
       

        List<Supplier> listAllSupplier = supp.getAllSupplier();
        List<Category> listAllCategory = cate.getAllCategory();


        request.setAttribute("listAllSupplier", listAllSupplier);
        request.setAttribute("listAllCategory", listAllCategory);

        request.getRequestDispatcher("NhaPhanPhoi.jsp").forward(request, response);
    }
}
