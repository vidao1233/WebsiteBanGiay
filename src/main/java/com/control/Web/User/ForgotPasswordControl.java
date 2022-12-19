package com.control.Web.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import com.entity.Account;
import com.entity.Email;
import com.entity.EmailUtils;
import com.service.IAccountService;
import com.service.impl.AccountService;

@WebServlet(urlPatterns = {"/forgotPassword"})
public class ForgotPasswordControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAccountService acc = new AccountService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("forgot-password.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String emailAddress = req.getParameter("email");
			String username = req.getParameter("username");
			Account accNew = new Account();
			
			Account account = acc.checkAccountExistByUsernameAndEmail(username, emailAddress);
			if(account == null) {
				req.setAttribute("error", "Email hoac username sai!");
			}
			if(account != null) {
				String pass = RandomStringUtils.randomAlphanumeric(6);
				Email email =new Email();
				email.setFrom("nna9220@gmail.com");
				email.setFromPassword("wevzzoqyzuystafv");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				sb.append("You are used the forgot password. <br> ");
				sb.append("Your password is <b>").append(pass).append(" </b> <br>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				accNew.setUser(account.getUser());
				accNew.setPass(pass);
				acc.recPass(accNew);
				req.setAttribute("mess", "Mat khau da duoc gui den email cua ban!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("forgot-password.jsp").forward(req, resp);
	}

}
