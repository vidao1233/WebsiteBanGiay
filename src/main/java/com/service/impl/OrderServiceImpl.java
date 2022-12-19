package com.service.impl;

import java.util.List;

import com.dao.IOrderDAO;
import com.dao.impl.OrderDAOImpl;
import com.entity.Order;
import com.entity.OrderItem;
import com.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
	IOrderDAO ordDAO = new OrderDAOImpl();
	@Override
	public void insert(Order ord) {
		ordDAO.insert(ord);
	}
	@Override
	public void insertItem(OrderItem ordItem) {
		ordDAO.inserItem(ordItem);
		
	}
	@Override
	public List<Order> getByAccount(int user) {
		// TODO Auto-generated method stub
		return ordDAO.getByAccount(user);
	}
	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return ordDAO.getAll();
	}
	@Override
	public void accept(Order ord) {
		Order old = ordDAO.getById(ord.getId());
		old.setStatus(ord.getStatus());
		ordDAO.accept(old);
	}
	@Override
	public Order getById(int id) {
		// TODO Auto-generated method stub
		return ordDAO.getById(id);
	}

}
