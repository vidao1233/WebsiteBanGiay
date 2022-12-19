package com.entity;

public class OrderItem {
	private int id;
	private int ordID;
	private int count;
	private int prodID;
	private String createAt;
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(int id, int ordID, int count, int prodID, String createAt) {
		super();
		this.id = id;
		this.ordID = ordID;
		this.count = count;
		this.prodID = prodID;
		this.createAt = createAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrdID() {
		return ordID;
	}
	public void setOrdID(int ordID) {
		this.ordID = ordID;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

}
