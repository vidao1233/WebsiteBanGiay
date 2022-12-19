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

@WebServlet(urlPatterns = {"/top5nhanvien"})
public class Top5NhanVienControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAccountService acc = new AccountService();
	ITongChiTieuBanHangService tong = new TongChiTieuBanHangService();

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
        List<TongChiTieuBanHang> listTop5NhanVien = tong.getTop5NhanVien();


        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("listTop5NhanVien", listTop5NhanVien);

        request.getRequestDispatcher("Top5NhanVien.jsp").forward(request, response);
    }
}
