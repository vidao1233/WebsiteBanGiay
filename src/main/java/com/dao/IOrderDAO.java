package com.dao;

import java.util.List;

import com.entity.Delivery;
import com.entity.Order;
import com.entity.OrderItem;

public interface IOrderDAO {
	void insert(Order ord);
	void inserItem(OrderItem ordItem);
	List<Order> getByAccount(int user);
	List<Order> getAll();
	void accept(Order ord);
	Order getById(int id);
	Delivery get(int id);
	List<Delivery> getAllDel();
}
