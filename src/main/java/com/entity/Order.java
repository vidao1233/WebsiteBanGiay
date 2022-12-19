package com.entity;

public class Order {
	private int id;
	private int uID;
	private int prodID;
	private int Address;
	private String detail;
	private String ward;
	private String district;
	private String province;
	private String phone;
	private int status;
	private String payment;
	private int delivery;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
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


	public Order(int id, int uID, int prodID, int address, String detail, String ward, String district, String province,
			String phone, int status, String payment, int delivery) {
		super();
		this.id = id;
		this.uID = uID;
		this.prodID = prodID;
		Address = address;
		this.detail = detail;
		this.ward = ward;
		this.district = district;
		this.province = province;
		this.phone = phone;
		this.status = status;
		this.payment = payment;
		this.delivery = delivery;
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

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public int getAddress() {
		return Address;
	}

	public void setAddress(int address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
}
