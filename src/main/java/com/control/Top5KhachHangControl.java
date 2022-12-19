package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Account;
import com.entity.TongChiTieuBanHang;
import com.service.IAccountService;
import com.service.ITongChiTieuBanHangService;
import com.service.impl.AccountService;
import com.service.impl.TongChiTieuBanHangService;

@WebServlet(urlPatterns = {"/top5khachhang"})
public class Top5KhachHangControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ITongChiTieuBanHangService tong = new TongChiTieuBanHangService();
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
      

        List<Account> listAllAccount = acc.getAllAccount();
        List<TongChiTieuBanHang> listTop5KhachHang = tong.getTop5KhachHang();


        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("listTop5KhachHang", listTop5KhachHang);
//        request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
        request.getRequestDispatcher("Top5KhachHang.jsp").forward(request, response);
    }
}
