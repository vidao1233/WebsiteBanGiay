package com.entity;

public class TongChiTieuBanHang {
	private int userID;
	private double tongChiTieu;
	private double tongBanHang;
	public TongChiTieuBanHang() {
		super();
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getTongChiTieu() {
		return tongChiTieu;
	}
	public void setTongChiTieu(double tongChiTieu) {
		this.tongChiTieu = tongChiTieu;
	}
	public double getTongBanHang() {
		return tongBanHang;
	}
	public void setTongBanHang(double tongBanHang) {
		this.tongBanHang = tongBanHang;
	}
	public TongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang) {
		super();
		this.userID = userID;
		this.tongChiTieu = tongChiTieu;
		this.tongBanHang = tongBanHang;
	}
	@Override
	public String toString() {
		return "TongChiTieuBanHang [userID=" + userID + ", tongChiTieu=" + tongChiTieu + ", tongBanHang=" + tongBanHang
				+ "]";
	}
}
