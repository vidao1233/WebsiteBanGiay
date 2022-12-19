package com.service.impl;

import java.util.List;

import com.dao.ITongChiTieuBanHangDAO;
import com.dao.impl.TongChiTieuBanHangDaoImpl;
import com.entity.TongChiTieuBanHang;
import com.service.ITongChiTieuBanHangService;

public class TongChiTieuBanHangService implements ITongChiTieuBanHangService{
	
	ITongChiTieuBanHangDAO tong = new TongChiTieuBanHangDaoImpl();

	@Override
	public List<TongChiTieuBanHang> getTop5KhachHang() {
		// TODO Auto-generated method stub
		return tong.getTop5KhachHang();
	}

	@Override
	public List<TongChiTieuBanHang> getTop5NhanVien() {
		// TODO Auto-generated method stub
		return tong.getTop5NhanVien();
	}

	@Override
	public TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID) {
		// TODO Auto-generated method stub
		return tong.checkTongChiTieuBanHangExist(userID);
	}

	@Override
	public void deleteTongChiTieuBanHangByUserID(String id) {
		// TODO Auto-generated method stub
		tong.deleteTongChiTieuBanHangByUserID(id);
	}

	@Override
	public void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang) {
		// TODO Auto-generated method stub
		tong.insertTongChiTieuBanHang(userID, tongChiTieu, tongBanHang);
	}

	@Override
	public void editTongChiTieu(int accountID, double totalMoneyVAT) {
		// TODO Auto-generated method stub
		tong.editTongChiTieu(accountID, totalMoneyVAT);
	}

	@Override
	public void editTongBanHang(int sell_ID, double tongTienBanHangThem) {
		// TODO Auto-generated method stub
		tong.editTongBanHang(sell_ID, tongTienBanHangThem);
	}
	

}
