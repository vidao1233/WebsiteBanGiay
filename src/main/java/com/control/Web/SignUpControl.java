package com.control.Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Account;
import com.service.IAccountService;
import com.service.impl.AccountService;

@WebServlet(urlPatterns = {"/signup"})
public class SignUpControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String email = request.getParameter("email");
        if(!pass.equals(re_pass)){
            response.sendRedirect("Login.jsp");
        }else{
            
            Account a = acc.checkAccountExist(user);
            if(a == null){
                //dc signup
                acc.singup(user, pass, email);
                response.sendRedirect("login");
            }else{
                //day ve trang login.jsp
                response.sendRedirect("Login.jsp");
            }
        }
        //sign up
    }
}
