package com.service.impl;

import java.util.List;

import com.dao.ISupplierDAO;
import com.dao.impl.SupplierDaoImpl;
import com.entity.Supplier;
import com.service.ISupplierService;

public class SupplierService implements ISupplierService{
	
	ISupplierDAO supp = new SupplierDaoImpl();

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return supp.getAllSupplier();
	}

	@Override
	public void deleteSupplier(String idSupplier) {
		// TODO Auto-generated method stub
		supp.deleteSupplier(idSupplier);
	}

	@Override
	public void insertSupplier(String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier,
			String cateID) {
		// TODO Auto-generated method stub
		supp.insertSupplier(nameSupplier, phoneSupplier, emailSupplier, addressSupplier, cateID);
	}

}
