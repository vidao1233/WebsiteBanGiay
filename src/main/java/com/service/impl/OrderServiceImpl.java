package com.service.impl;

import com.dao.IOrderDAO;
import com.dao.impl.OrderDAOImpl;
import com.entity.Address;
import com.entity.Order;
import com.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
	IOrderDAO ordDAO = new OrderDAOImpl();
	@Override
	public void insert(Order ord) {
		ordDAO.insert(ord);
	}

}
