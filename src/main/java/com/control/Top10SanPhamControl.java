package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Product;
import com.entity.SoLuongDaBan;
import com.service.IProductService;
import com.service.ISoLuongDaBanService;
import com.service.impl.ProductService;
import com.service.impl.SoLuongDaBanService;

@WebServlet(urlPatterns = {"/top10"})
public class Top10SanPhamControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IProductService prod = new ProductService();
	ISoLuongDaBanService so = new SoLuongDaBanService();

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
        
        List<Product> listAllProduct = prod.getAllProduct();
        List<SoLuongDaBan> listTop10Product = so.getTop10SanPhamBanChay();


        
        
        request.setAttribute("listAllProduct", listAllProduct);
        request.setAttribute("listTop10Product", listTop10Product);

        request.getRequestDispatcher("Top10SanPhamBanChay.jsp").forward(request, response);
    }
}
