package com.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Account;
import com.entity.Category;
import com.entity.Product;
import com.service.ICategoryService;
import com.service.IProductService;
import com.service.impl.CategoryService;
import com.service.impl.ProductService;

@WebServlet(urlPatterns = {"/manager"})
public class ManagerControl extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IProductService prod = new ProductService();
	ICategoryService cate = new CategoryService();

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
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        int id = a.getId();
        String index = request.getParameter("index");
        if(index == null) {
        	index="1";
        }
        int indexPage = Integer.parseInt(index);
        
        List<Product> list = prod.getProductBySellIDAndIndex(id, indexPage);
        List<Category> listC = cate.getAllCategory();
        int allProductBySellID = prod.countAllProductBySellID(id);
        int endPage = allProductBySellID/5;
        if(allProductBySellID % 5 != 0) {
        	endPage++;
        }
        
        
        request.setAttribute("tag", indexPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("listCC", listC);
        request.setAttribute("listP", list);
   //     request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
        request.getRequestDispatcher("QuanLySanPham.jsp").forward(request, response);
    }
}
