package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Category;
import com.entity.Product;
import com.service.ICategoryService;
import com.service.IProductService;
import com.service.impl.CategoryService;
import com.service.impl.ProductService;

@WebServlet(urlPatterns = {"/loadProduct"})
public class LoadControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICategoryService cate = new CategoryService();
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
        String id = request.getParameter("pid");
        
        Product p = prod.getProductByID(id);
        List<Category> listC = cate.getAllCategory();

        request.setAttribute("detail", p);
        request.setAttribute("listCC", listC);
        request.getRequestDispatcher("Edit.jsp").forward(request, response);
    }
}
