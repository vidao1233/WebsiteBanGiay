package com.service.impl;

import java.util.List;

import com.dao.IOrderItem;
import com.dao.impl.OrderItemDAOImpl;
import com.entity.OrderItem;
import com.service.IOrderItemService;

public class OrderItemServiceImpl implements IOrderItemService {
	IOrderItem ordIDAO = new OrderItemDAOImpl();
	@Override
	public List<OrderItem> getByOD(int ord) {
		// TODO Auto-generated method stub
		return ordIDAO.getByOD(ord);
	}
	@Override
	public List<OrderItem> getAll() {
		// TODO Auto-generated method stub
		return ordIDAO.getAll();
	}

}
