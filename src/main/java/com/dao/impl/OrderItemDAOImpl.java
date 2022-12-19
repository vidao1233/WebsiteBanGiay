package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.context.DBContext;
import com.dao.IOrderItem;
import com.entity.OrderItem;

public class OrderItemDAOImpl extends DBContext implements IOrderItem {

	@Override
	public List<OrderItem> getByOD(int ord) {
		List<OrderItem> ords = new ArrayList<OrderItem>();
		String sql = "SELECT * FROM OrderItem WHERE ordID = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ord);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem ordI = new OrderItem();
				ordI.setId(rs.getInt("id"));
				ordI.setOrdID(rs.getInt("ordID"));
				ordI.setProdID(rs.getInt("prodID"));
				ordI.setCount(rs.getInt("count"));
				ordI.setCreateAt(rs.getString("createAt"));
				ords.add(ordI);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ords;
	}

	@Override
	public List<OrderItem> getAll() {
		List<OrderItem> ords = new ArrayList<OrderItem>();
		String sql = "SELECT * FROM OrderItem";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem ordI = new OrderItem();
				ordI.setId(rs.getInt("id"));
				ordI.setOrdID(rs.getInt("ordID"));
				ordI.setProdID(rs.getInt("prodID"));
				ordI.setCount(rs.getInt("count"));
				ordI.setCreateAt(rs.getString("createAt"));
				ords.add(ordI);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ords;
	}

}
