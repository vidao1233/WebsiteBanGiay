package com.control.Admin.Product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.service.IProductService;
import com.service.impl.ProductService;

@WebServlet(urlPatterns = {"/add"})
public class AddControl extends HttpServlet{

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
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        
        String pimage2 = request.getParameter("image2");
        String pimage3 = request.getParameter("image3");
        String pimage4 = request.getParameter("image4");
        String pmodel = request.getParameter("model");
        String pcolor = request.getParameter("color");
        String pdelivery = request.getParameter("delivery");
        
        String pprice = request.getParameter("price");
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        String pcategory = request.getParameter("category");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();        
        
        prod.insertProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, sid, pmodel, pcolor, pdelivery, pimage2, pimage3, pimage4);
        request.setAttribute("mess", "Product Added!");
        request.getRequestDispatcher("manager").forward(request, response);
    }
}
