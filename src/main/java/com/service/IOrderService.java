package com.service;

import java.util.List;

import com.entity.Order;
import com.entity.OrderItem;

public interface IOrderService {
	void insert(Order ord);
	void insertItem(OrderItem ordItem);
	List<Order> getByAccount(int user);
	List<Order> getAll();
	void accept(Order ord);
	Order getById(int id);
}
