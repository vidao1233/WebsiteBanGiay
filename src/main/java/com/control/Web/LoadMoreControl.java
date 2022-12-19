package com.control.Web;

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

@WebServlet(urlPatterns = {"/load"})
public class LoadMoreControl extends HttpServlet{

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
        //tam thoi load ra 3 san pham truoc 
        String amount = request.getParameter("exits");
        int iamount = Integer.parseInt(amount);
        
        List<Product> list = prod.getNext3Product(iamount);
        PrintWriter out = response.getWriter();

        for (Product o : list) {
            out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\n"
                    + "                                <div class=\"card\">\n"
                    + "                                    <img class=\"card-img-top\" src=\""+o.getImage()+"\" alt=\"Card image cap\">\n"
                    + "                                    <div class=\"card-body\">\n"
                    + "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid="+o.getId()+"\" title=\"View Product\">"+o.getName()+"</a></h4>\n"
                    + "                                        <p class=\"card-text show_txt\">"+o.getTitle()+"</p>\n"
                    + "                                        <div class=\"row\">\n"
                    + "                                            <div class=\"col\">\n"
                    + "                                                <p class=\"btn btn-danger btn-block\">"+o.getPrice()+" $</p>\n"
                    + "                                            </div>\n"
                    + "                                            <div class=\"col\">\n"
                    + "                                                <a href=\"addCart?pid="+o.getId()+"\" class=\"btn btn-success btn-block\">Add to cart</a>\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "                            </div>");
        }
    }
}
