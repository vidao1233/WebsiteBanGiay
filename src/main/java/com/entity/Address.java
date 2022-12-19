package com.entity;

public class Address {
	private int id;
	private int uID;
	private String detail;
	private String ward;
	private String district;
	private String province;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int id, int uID, String detail, String ward, String district, String province) {
		super();
		this.id = id;
		this.uID = uID;
		this.detail = detail;
		this.ward = ward;
		this.district = district;
		this.province = province;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

}
