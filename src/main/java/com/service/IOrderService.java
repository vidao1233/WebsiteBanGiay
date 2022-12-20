package com.service;

import java.util.List;

import com.entity.Delivery;
import com.entity.Order;
import com.entity.OrderItem;

public interface IOrderService {
	void insert(Order ord);
	void insertItem(OrderItem ordItem);
	List<Order> getByAccount(int user);
	List<Order> getAll();
	void accept(Order ord);
	Order getById(int id);
	Delivery get(int id);
	List<Delivery> getAllDel();
}
