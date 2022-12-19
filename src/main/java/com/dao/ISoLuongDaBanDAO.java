package com.dao;

import java.util.List;

import com.entity.SoLuongDaBan;

public interface ISoLuongDaBanDAO {
	public List<SoLuongDaBan> getTop10SanPhamBanChay();
	public SoLuongDaBan checkSoLuongDaBanExist(int productID);
	public void insertSoLuongDaBan(int productID, int soLuongDaBan);
	public void editSoLuongDaBan(int productID, int soLuongBanThem);
}
