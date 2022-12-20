package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.context.DBContext;
import com.dao.IOrderDAO;
import com.entity.Address;
import com.entity.Delivery;
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
	public List<Order> getByAccount(int user) {
		List<Order> ords = new ArrayList<Order>();
		String sql = "SELECT * FROM Orders WHERE uID = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order ord = new Order();
				ord.setId(rs.getInt("id"));
				ord.setuID(rs.getInt("uID"));
				ord.setAddress(rs.getInt("Address"));
				ord.setName(rs.getString("name"));
				ord.setPayment(rs.getString("payment"));
				ord.setDelivery(rs.getInt("delivery"));
				ord.setStatus(rs.getInt("status"));
				ord.setPhone(rs.getString("phone"));
				ord.setProvince(rs.getString("province"));
				ord.setDistrict(rs.getString("district"));
				ord.setWard(rs.getString("ward"));
				ord.setDetail(rs.getString("detail"));
				ords.add(ord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ords;
	}

	@Override
	public List<Order> getAll() {
		List<Order> ords = new ArrayList<Order>();
		String sql = "SELECT * FROM Orders";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order ord = new Order();
				ord.setId(rs.getInt("id"));
				ord.setuID(rs.getInt("uID"));
				ord.setAddress(rs.getInt("Address"));
				ord.setName(rs.getString("name"));
				ord.setPayment(rs.getString("payment"));
				ord.setDelivery(rs.getInt("delivery"));
				ord.setStatus(rs.getInt("status"));
				ord.setPhone(rs.getString("phone"));
				ord.setProvince(rs.getString("province"));
				ord.setDistrict(rs.getString("district"));
				ord.setWard(rs.getString("ward"));
				ord.setDetail(rs.getString("detail"));
				ords.add(ord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ords;
	}

	@Override
	public void accept(Order ord) {
		String sql = "UPDATE Orders SET status = 1 WHERE id =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ord.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Order getById(int id) {
		String sql = "SELECT * FROM Orders WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order ord = new Order();
				ord.setId(rs.getInt("id"));
				ord.setuID(rs.getInt("uID"));
				ord.setAddress(rs.getInt("Address"));
				ord.setName(rs.getString("name"));
				ord.setPayment(rs.getString("payment"));
				ord.setDelivery(rs.getInt("delivery"));
				ord.setStatus(rs.getInt("status"));
				ord.setPhone(rs.getString("phone"));
				ord.setProvince(rs.getString("province"));
				ord.setDistrict(rs.getString("district"));
				ord.setWard(rs.getString("ward"));
				ord.setDetail(rs.getString("detail"));
				return ord;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Delivery get(int id) {
		String sql = "SELECT * FROM Delivery WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Delivery ord = new Delivery();
				ord.setId(rs.getInt("id"));
				ord.setName(rs.getString("name"));
				return ord;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Delivery> getAllDel() {
		List<Delivery> dels = new ArrayList<Delivery>();
		String sql = "SELECT * FROM Delivery";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Delivery ord = new Delivery();
				ord.setId(rs.getInt("id"));
				ord.setName(rs.getString("name"));
				dels.add(ord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dels;
	}

}
