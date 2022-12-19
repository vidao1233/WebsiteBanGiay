package com.control.Admin.Account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.service.IAccountService;
import com.service.impl.AccountService;

@WebServlet(urlPatterns = {"/managerAccount"})
public class ManagerAccountControl extends HttpServlet{

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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        String indexPage = request.getParameter("index");
		String indexPage1 = request.getParameter("index1");
		if(indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		int indexp1 = Integer.parseInt(indexPage1);
		int countA = acc.countAll();
		int endPage = countA/3;
		if(countA % 3 !=0) {
			endPage++;
		}
		if("-1".equals(indexPage1)){
			List<Account> list = acc.getAllAccount();
			request.setAttribute("listA", list);
		}else{
			List<Account> accPage = acc.pagingProduct(indexp, indexp1);
			request.setAttribute("listA", accPage);
			System.out.println(accPage);
		}
		request.setAttribute("endP", endPage);
		request.setAttribute("tag", indexp);
		request.setAttribute("tag1", indexp1);
		request.setAttribute("indexP2", indexPage1);
		request.setAttribute("countAccountAll", countA);
        request.getRequestDispatcher("QuanLyTaiKhoan.jsp").forward(request, response);
    }
}
