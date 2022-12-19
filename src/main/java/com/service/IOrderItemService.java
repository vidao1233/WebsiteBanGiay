package com.service;

import java.util.List;

import com.entity.OrderItem;

public interface IOrderItemService {
	List<OrderItem> getByOD(int ord);
	List<OrderItem> getAll();

}
