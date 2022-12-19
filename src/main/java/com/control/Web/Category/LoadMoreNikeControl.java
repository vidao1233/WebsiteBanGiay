package com.control.Web.Category;

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

@WebServlet(urlPatterns = {"/loadNike"})
public class LoadMoreNikeControl extends HttpServlet{

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
        
        String amount = request.getParameter("exitsNike");
        int iamount = Integer.parseInt(amount);
        
        List<Product> list = prod.getNext4NikeProduct(iamount);
        PrintWriter out = response.getWriter();

        for (Product o : list) {
            out.println("<div class=\"productNike col-12 col-md-6 col-lg-3\">\r\n"
            		+ "                                <div class=\"card\">\r\n"
            		+ "                                 <div class=\"view zoom z-depth-2 rounded\">\r\n"
            		+ "                                    <img class=\"img-fluid w-100\" src=\""+o.getImage()+"\" alt=\"Card image cap\">\r\n"
            		+ "                                    </div>\r\n"
            		+ "                                    <div class=\"card-body\">\r\n"
            		+ "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid="+o.getId()+"\" title=\"View Product\">"+o.getName()+"</a></h4>\r\n"
            		+ "                                        <p class=\"card-text show_txt\">"+o.getTitle()+"</p>\r\n"
            		+ "                                        <div class=\"row\">\r\n"
            		+ "                                            <div class=\"col\">\r\n"
            		+ "                                                <p class=\"btn btn-success btn-block\">"+o.getPrice()+" $</p>\r\n"
            		+ "                                            </div>\r\n"
            		+ "                                            \r\n"
            		+ "                                        </div>\r\n"
            		+ "                                    </div>\r\n"
            		+ "                                </div>\r\n"
            		+ "                            </div>");
        }
    }
}
