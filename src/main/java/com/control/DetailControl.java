package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Account;
import com.entity.Product;
import com.entity.Review;
import com.service.IAccountService;
import com.service.IProductService;
import com.service.IReviewService;
import com.service.impl.AccountService;
import com.service.impl.ProductService;
import com.service.impl.ReviewService;

@WebServlet(urlPatterns = {"/detail"})
public class DetailControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IProductService prod = new ProductService();
	IReviewService rev = new ReviewService();
	IAccountService acc = new AccountService();

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
        
        int cateIDProductDetail = prod.getCateIDByProductID(id);
        List<Product> listRelatedProduct = prod.getRelatedProduct(cateIDProductDetail);
        
        List<Review> listAllReview = rev.getAllReviewByProductID(id);
        int countAllReview = listAllReview.size();
        
        List<Account> listAllAcount = acc.getAllAccount();
        
        Product last = prod.getLast();

        request.setAttribute("detail", p);
        request.setAttribute("listRelatedProduct", listRelatedProduct);
        request.setAttribute("listAllReview", listAllReview);
        request.setAttribute("listAllAcount", listAllAcount);
        request.setAttribute("countAllReview", countAllReview);
        request.setAttribute("p", last);
        request.getRequestDispatcher("DetailProduct.jsp").forward(request, response);
    }
}
