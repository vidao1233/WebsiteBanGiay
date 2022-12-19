package com.control.Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.service.IAccountService;
import com.service.impl.AccountService;

@WebServlet(urlPatterns = {"/login"})
public class LoginControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAccountService acc = new AccountService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie arr[] = req.getCookies();
    	if(arr != null) {
    		for(Cookie o : arr) {
        		if(o.getName().equals("userC")) {
        			req.setAttribute("username", o.getValue());
        		}
        		if(o.getName().equals("passC")) {
        			req.setAttribute("password", o.getValue());
        		}
        	}
    	}
    	//b2: set user,pass to login form
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 resp.setContentType("text/html;charset=UTF-8");
         String username = req.getParameter("user");
         String password = req.getParameter("pass");
         String remember =req.getParameter("remember");
         
         Account a = acc.login(username, password);
         if (a == null) {
             req.setAttribute("error", "Sai username hoac password!");
             req.getRequestDispatcher("Login.jsp").forward(req, resp);
         } else {
             HttpSession session = req.getSession();
             session.setAttribute("acc", a);
             session.setMaxInactiveInterval(60*60*24);
           //luu account len tren cookie
             Cookie u = new Cookie("userC", username);
             Cookie p = new Cookie("passC", password);
             if(remember != null) {
            	 p.setMaxAge(60*60*24);
             }else {
            	 p.setMaxAge(0);
             }
             
             u.setMaxAge(60*60*24*365);//1 nam

             resp.addCookie(u);//luu u va p len Chrome
             resp.addCookie(p);
             
             resp.sendRedirect("home");
         }
	}
	
}
