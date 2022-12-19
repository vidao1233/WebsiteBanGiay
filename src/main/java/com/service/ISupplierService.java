package com.service;

import java.util.List;

import com.entity.Supplier;

public interface ISupplierService {
	public List<Supplier> getAllSupplier();
	public void deleteSupplier(String idSupplier);
	public void insertSupplier(String nameSupplier, String phoneSupplier, String emailSupplier, 
			String addressSupplier);
}
