package com.control.Web.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Cart;
import com.entity.Delivery;
import com.entity.Order;
import com.entity.OrderItem;
import com.entity.Product;
import com.service.IOrderItemService;
import com.service.IOrderService;
import com.service.IProductService;
import com.service.impl.OrderItemServiceImpl;
import com.service.impl.OrderServiceImpl;
import com.service.impl.ProductService;
@WebServlet(urlPatterns = {"/detailOrder"})
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IOrderService ords = new OrderServiceImpl();
	IOrderItemService ordis = new OrderItemServiceImpl();
	IProductService prod = new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		Order listOrder = ords.getById(id);
		List<OrderItem> listOrdI = ordis.getByOD(listOrder.getId());
		List<Product> listProd = new ArrayList<Product>();
		Delivery del = ords.get(listOrder.getDelivery());
		int amount =0;
        for(OrderItem o : listOrdI) {
        	listProd = prod.getByOItem(o.getProdID());
        	req.setAttribute("listProd", listProd);
        	amount += o.getCount();
        }
        req.setAttribute("del", del);
        req.setAttribute("amount", amount);
        req.setAttribute("listOrdI", listOrdI);
        req.setAttribute("order", listOrder);
		RequestDispatcher dispatcher = req.getRequestDispatcher("detailOrder.jsp");
		dispatcher.forward(req, resp);
	}

}
