package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.context.DBContext;
import com.dao.IOrderDAO;
import com.entity.Address;
import com.entity.Order;
import com.entity.OrderItem;

public class OrderDAOImpl extends DBContext implements IOrderDAO {

	public void insert(Order ord) {
		String sql = "SET IDENTITY_INSERT Orders ON INSERT INTO Orders(id,uID,province,district,ward,detail,phone,status,payment,delivery,name) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ord.getId());
			ps.setInt(2, ord.getuID());
			ps.setString(3, ord.getProvince());
			ps.setString(4, ord.getDistrict());
			ps.setString(5, ord.getWard());
			ps.setString(6, ord.getDetail());
			ps.setString(7, ord.getPhone());
			ps.setInt(8, ord.getStatus());
			ps.setString(9, ord.getPayment());
			ps.setInt(10, ord.getDelivery());
			ps.setString(11, ord.getName());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void inserItem(OrderItem ordItem) {
		String sql = "INSERT INTO OrderItem(ordID,prodID,count,createAt) "
				+ "VALUES (?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ordItem.getOrdID());
			ps.setInt(2, ordItem.getProdID());
			ps.setInt(3, ordItem.getCount());
			ps.setString(4, ordItem.getCreateAt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getByAccount(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
