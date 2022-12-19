package com.control.Web;

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

@WebServlet(urlPatterns = {"/home"})
public class HomeControl extends HttpServlet{

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
        List<Category> listC = cate.getAllCategory();
        List<Product> list = prod.getTop3();
        List<Product> list8Last = prod.get8Last();
        List<Product> list4NikeLast = prod.get4NikeLast();
        List<Product> list4AdidasLast = prod.get4AdidasLast();
        
        
        Product last = prod.getLast();
        
        //b2: set data to jsp
        request.setAttribute("listP", list);
        request.setAttribute("listCC", listC);
        request.setAttribute("list8Last", list8Last);
        request.setAttribute("list4NikeLast", list4NikeLast);
        request.setAttribute("list4AdidasLast", list4AdidasLast);
        request.setAttribute("p", last);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
        //404 -> url
        //500 -> jsp properties
    }
}
