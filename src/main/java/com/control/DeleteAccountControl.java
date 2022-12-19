package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IAccountService;
import com.service.ICartService;
import com.service.IInvoiceService;
import com.service.IProductService;
import com.service.IReviewService;
import com.service.ITongChiTieuBanHangService;
import com.service.impl.AccountService;
import com.service.impl.CartService;
import com.service.impl.InvoiceService;
import com.service.impl.ProductService;
import com.service.impl.ReviewService;
import com.service.impl.TongChiTieuBanHangService;

@WebServlet(urlPatterns = {"/deleteAccount"})
public class DeleteAccountControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAccountService acc = new AccountService();
	ICartService crt = new CartService();
	IProductService prod = new ProductService();
	IReviewService rev = new ReviewService();
	IInvoiceService inv = new InvoiceService();
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
        String id = request.getParameter("id");
        System.out.println("id: "+id);
        
        crt.deleteCartByAccountID(Integer.parseInt(id));
        prod.deleteProductBySellID(id);
        rev.deleteReviewByAccountID(id);
        inv.deleteInvoiceByAccountId(id);
        tong.deleteTongChiTieuBanHangByUserID(id);
        acc.deleteAccount(id);
        
        request.setAttribute("mess", "Account Deleted!");
        request.getRequestDispatcher("managerAccount").forward(request, response);
    }

}
