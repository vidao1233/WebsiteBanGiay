package com.service.impl;

import java.util.List;

import com.dao.ISoLuongDaBanDAO;
import com.dao.impl.SoLuongDaBanDaoImpl;
import com.entity.SoLuongDaBan;
import com.service.ISoLuongDaBanService;

public class SoLuongDaBanService implements ISoLuongDaBanService{
	
	ISoLuongDaBanDAO so = new SoLuongDaBanDaoImpl();

	@Override
	public List<SoLuongDaBan> getTop10SanPhamBanChay() {
		// TODO Auto-generated method stub
		return so.getTop10SanPhamBanChay();
	}

	@Override
	public SoLuongDaBan checkSoLuongDaBanExist(int productID) {
		// TODO Auto-generated method stub
		return so.checkSoLuongDaBanExist(productID);
	}

	@Override
	public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
		// TODO Auto-generated method stub
		so.insertSoLuongDaBan(productID, soLuongDaBan);
	}

	@Override
	public void editSoLuongDaBan(int productID, int soLuongBanThem) {
		// TODO Auto-generated method stub
		so.editSoLuongDaBan(productID, soLuongBanThem);
	}

}
