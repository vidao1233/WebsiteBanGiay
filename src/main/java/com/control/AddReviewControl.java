package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.entity.Review;
import com.service.IReviewService;
import com.service.impl.ReviewService;

@WebServlet(urlPatterns = {"/addReview"})
public class AddReviewControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IReviewService rev = new ReviewService();

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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if(a==null) {
        	response.sendRedirect("login");
        	return;
        }
        int accountID = a.getId();
        String contentReview = request.getParameter("contentReview");
        int productID = Integer.parseInt(request.getParameter("productID"));
        
        rev.insertReview(accountID, productID, contentReview);
      
        Review newReview = new Review();
        newReview = rev.getNewReview(accountID, productID);
        PrintWriter out = response.getWriter();

        
            out.println(" <div class=\"media mt-3 mb-4\">\r\n"
            		+ "              <img class=\"d-flex mr-3 z-depth-1\" src=\"https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg\"\r\n"
            		+ "                width=\"62\" alt=\"Generic placeholder image\">\r\n"
            		+ "              <div class=\"media-body\">\r\n"
            		+ "                <div class=\"d-flex justify-content-between\">\r\n"
            		+ "                  <p class=\"mt-1 mb-2\">\r\n"
            		+ "                    <strong>"+a.getUser()+"</strong>\r\n"
            		+ "                    <span>� </span><span>"+newReview.getDateReview()+"</span>\r\n"
            		+ "                  </p>\r\n"
            		+ "                </div>\r\n"
            		+ "                <p class=\"mb-0\">"+newReview.getContentReview()+"</p>\r\n"
            		+ "              </div>\r\n"
            		+ "            </div>\r\n"
            		+ "            <hr>    ");
       
    }
}
