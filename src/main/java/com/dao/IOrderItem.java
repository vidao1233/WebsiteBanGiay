package com.dao;

import java.util.List;

import com.entity.OrderItem;

public interface IOrderItem {
	List<OrderItem> getByOD(int ord);
	List<OrderItem> getAll();
}
