package com.control.Admin.Order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.entity.Order;
import com.service.IOrderService;
import com.service.impl.OrderServiceImpl;

@WebServlet(urlPatterns = { "/manageOrder" })
public class OrderManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IOrderService ords = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Order> ord = ords.getAll();
		req.setAttribute("ords", ord);
		RequestDispatcher dispatcher = req.getRequestDispatcher("manageOrder.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Order ord = new Order();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				System.out.println("item:" + item.getFieldName());
				if (item.getFieldName().equals("id")) {
					ord.setId(Integer.parseInt(item.getString()));
				}
				System.out.println(req.getParameter("id"));
				ords.accept(ord);
				resp.sendRedirect(req.getContextPath() + "/manageOrder");
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
