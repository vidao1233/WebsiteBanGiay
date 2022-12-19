package com.control.Web.Product;

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

@WebServlet(urlPatterns = {"/searchAjaxPriceMinToMax"})
public class SearchAjaxPriceMinToMaxShopControl extends HttpServlet{

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
        
        request.setCharacterEncoding("UTF-8");
        String priceMin = request.getParameter("priceMin");
        String priceMax = request.getParameter("priceMax");
        
        List<Product> list = prod.searchByPriceMinToMax(priceMin,priceMax);
        PrintWriter out = response.getWriter();
        for (Product o : list) {
        	out.println("  <!-- Grid column -->\r\n"
        			+ "              <div class=\"col-md-4 mb-5\">\r\n"
        			+ "\r\n"
        			+ "                <!-- Card -->\r\n"
        			+ "                <div class=\"\">\r\n"
        			+ "\r\n"
        			+ "                  <div class=\"view zoom overlay rounded z-depth-2\">\r\n"
        			+ "                    <img class=\"img-fluid w-100\"\r\n"
        			+ "                      src=\""+o.getImage()+"\" alt=\"Sample\">\r\n"
        			+ "                    <a href=\"detail?pid="+o.getId()+"\">\r\n"
        			+ "                      <div class=\"mask\">\r\n"
        			+ "                        <img class=\"img-fluid w-100\"\r\n"
        			+ "                          src=\""+o.getImage()+"\">\r\n"
        			+ "                        <div class=\"mask rgba-black-slight\"></div>\r\n"
        			+ "                      </div>\r\n"
        			+ "                    </a>\r\n"
        			+ "                  </div>\r\n"
        			+ "\r\n"
        			+ "                  <div class=\"text-center pt-4\">\r\n"
        			+ "\r\n"
        			+ "                    <h5>"+o.getName()+"</h5>\r\n"
        			+ "                    <p><span class=\"mr-1\"><strong>"+o.getPrice()+"$</strong></span></p>\r\n"
        			+ "\r\n"
        			+ "                  </div>\r\n"
        			+ "\r\n"
        			+ "                </div>\r\n"
        			+ "                <!-- Card -->\r\n"
        			+ "\r\n"
        			+ "              </div>\r\n"
        			+ "              <!-- Grid column -->");
        }
    }
}
