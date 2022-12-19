package com.entity;

public class SoLuongDaBan {
	private int productID;
	private int soLuongDaBan;
	public SoLuongDaBan() {
		super();
	}
	@Override
	public String toString() {
		return "SoLuongDaBan [productID=" + productID + ", soLuongDaBan=" + soLuongDaBan + "]";
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getSoLuongDaBan() {
		return soLuongDaBan;
	}
	public void setSoLuongDaBan(int soLuongDaBan) {
		this.soLuongDaBan = soLuongDaBan;
	}
	public SoLuongDaBan(int productID, int soLuongDaBan) {
		super();
		this.productID = productID;
		this.soLuongDaBan = soLuongDaBan;
	}
}
