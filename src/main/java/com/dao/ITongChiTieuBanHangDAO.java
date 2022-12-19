package com.dao;

import java.util.List;

import com.entity.TongChiTieuBanHang;

public interface ITongChiTieuBanHangDAO {
	public List<TongChiTieuBanHang> getTop5KhachHang();
	public List<TongChiTieuBanHang> getTop5NhanVien();
	public TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID);
	public void deleteTongChiTieuBanHangByUserID(String id);
	public void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang);
	public void editTongChiTieu(int accountID, double totalMoneyVAT);
	public void editTongBanHang(int sell_ID, double tongTienBanHangThem);
}
