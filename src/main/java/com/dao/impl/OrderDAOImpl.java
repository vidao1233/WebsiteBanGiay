package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.context.DBContext;
import com.dao.IOrderDAO;
import com.entity.Address;
import com.entity.Order;

public class OrderDAOImpl extends DBContext implements IOrderDAO {

	public void insert(Order ord) {
		String sql = "INSERT INTO Orders(uID,prodID,province,district,ward,detail,phone,status,payment,delivery) "
				+ "VALUES (?,?,?,?,?,?,?,0,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ord.getuID());
			ps.setInt(2, ord.getProdID());
			ps.setInt(3, ord.getAddress());
			ps.setString(4, ord.getPhone());
			ps.setInt(5, ord.getStatus());
			ps.setString(6, ord.getPayment());
			ps.setInt(7, ord.getDelivery());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
