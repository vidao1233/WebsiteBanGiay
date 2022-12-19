package com.dao;

import java.util.List;

import com.entity.Order;
import com.entity.OrderItem;

public interface IOrderDAO {
	void insert(Order ord);
	void inserItem(OrderItem ordItem);
	List<Order> getByAccount(String user);

}
