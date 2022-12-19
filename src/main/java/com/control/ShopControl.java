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

@WebServlet(urlPatterns = {"/shop"})
public class ShopControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IProductService prod = new ProductService();
	ICategoryService cate = new CategoryService();

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
        //b1: get data from dao
        
//        List<Product> list = dao.getAllProduct();
        List<Category> listC = cate.getAllCategory();

       
        
        String index = request.getParameter("index");
        if(index == null) {
        	index="1";
        }
        int indexPage = Integer.parseInt(index);        
      
        List<Product> list = prod.getProductByIndex(indexPage);
//        List<Category> listC = dao.getAllCategory();
        int allProduct = prod.countAllProduct();
        int endPage = allProduct/9;
        if(allProduct % 9 != 0) {
        	endPage++;
        }        
        
        request.setAttribute("tag", indexPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("listCC", listC);
        request.setAttribute("listP", list);      
        
        request.getRequestDispatcher("Shop.jsp").forward(request, response);
        //404 -> url
        //500 -> jsp properties
    }
}
