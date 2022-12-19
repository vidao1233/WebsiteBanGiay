package com.control.Admin.Category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Product;
import com.service.IProductService;
import com.service.impl.ProductService;

@WebServlet(urlPatterns = {"/category"})
public class CategoryControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
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
        String cateID = request.getParameter("cid");
        //da lay dc category id ve roi
        List<Product> list = prod.getProductByCID(cateID);
        //in list p day
        PrintWriter out = response.getWriter();
        for(Product o : list) {
        	out.println(" <div class=\"product col-12 col-md-6 col-lg-4\">\r\n"
        			+ "                                <div class=\"card\">\r\n"
        			+ "                                    <img class=\"card-img-top\" src=\""+o.getImage()+"\" alt=\"Card image cap\">\r\n"
        			+ "                                    <div class=\"card-body\">\r\n"
        			+ "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid="+o.getId()+"\" title=\"View Product\">"+o.getName()+"</a></h4>\r\n"
        			+ "                                        <p class=\"card-text show_txt\">"+o.getTitle()+"</p>\r\n"
        			+ "                                        <div class=\"row\">\r\n"
        			+ "                                            <div class=\"col\">\r\n"
        			+ "                                                <p class=\"btn btn-danger btn-block\">"+o.getPrice()+" $</p>\r\n"
        			+ "                                            </div>\r\n"
        			+ "                                            <div class=\"col\">\r\n"
        			+ "                                                <a href=\"#\" class=\"btn btn-success btn-block\">Add to cart</a>\r\n"
        			+ "                                            </div>\r\n"
        			+ "                                        </div>\r\n"
        			+ "                                    </div>\r\n"
        			+ "                                </div>\r\n"
        			+ "                            </div>");
        }
//        List<Category> listC = dao.getAllCategory();
//        Product last = dao.getLast();
//        
//        
//        
//        request.setAttribute("listP", list);
//        request.setAttribute("listCC", listC);
//        request.setAttribute("p", last);
//        request.setAttribute("tag", cateID);
//        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
}
