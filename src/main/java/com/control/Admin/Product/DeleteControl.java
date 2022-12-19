package com.control.Admin.Product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ICartService;
import com.service.IProductService;
import com.service.IReviewService;
import com.service.impl.CartService;
import com.service.impl.ProductService;
import com.service.impl.ReviewService;

@WebServlet(urlPatterns = {"/delete"})
public class DeleteControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ICartService crt = new CartService();
	IReviewService rev = new ReviewService();
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
        String pid = request.getParameter("pid");
        
        crt.deleteCartByProductID(pid);
        rev.deleteReviewByProductID(pid);
        prod.deleteProduct(pid);
        request.setAttribute("mess", "Deleted!");
        request.getRequestDispatcher("manager").forward(request, response);
    }
}
