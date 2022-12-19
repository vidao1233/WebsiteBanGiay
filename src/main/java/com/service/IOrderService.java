package com.service;

import com.entity.Order;
import com.entity.OrderItem;

public interface IOrderService {
	void insert(Order ord);
	void insertItem(OrderItem ordItem);

}
