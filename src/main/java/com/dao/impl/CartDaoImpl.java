package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.context.DBContext;
import com.dao.ICartDAO;
import com.entity.Cart;

public class CartDaoImpl extends DBContext implements ICartDAO{
	public List<Cart> getCartByAccountID(int accountID) {
   	 List<Cart> list = new ArrayList<>();
       String query = "select * from Cart where accountID = ?";
       try {
    	   Connection con = super.getConnection();
    	   PreparedStatement ps = con.prepareStatement(query);
           ps.setInt(1, accountID);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               list.add(new Cart(rs.getInt(1),
                       rs.getInt(2),
                       rs.getInt(3),
                       rs.getInt(4),
                       rs.getString(5)));
           }
       } catch (Exception e) {
       }
       return list;
   }
	public Cart checkCartExist(int accountID,int productID) {

	       String query = "select * from Cart\r\n"
	       		+ "where [accountID] = ? and [productID] = ?";
	       try {
	    	   Connection con = super.getConnection();
	    	   PreparedStatement ps = con.prepareStatement(query);
	           ps.setInt(1, accountID);
	           ps.setInt(2, productID);
	           ResultSet rs = ps.executeQuery();
	           while (rs.next()) {
	               return new Cart(rs.getInt(1),
	                       rs.getInt(2),
	                       rs.getInt(3),
	                       rs.getInt(4),
	                       rs.getString(5));
	           }
	       } catch (Exception e) {
	       }
	      return null;
	   }
	public void deleteCartByAccountID(int accountID) {
        String query = "delete from Cart \r\n"
        		+ "where [accountID]=?";
        try {
        	Connection con = super.getConnection();
	    	PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void deleteCartByProductID(String productID) {
        String query = "delete from Cart where [productID]=?";
        try {
        	Connection con = super.getConnection();
	    	PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void deleteCart(int productID) {
        String query = "delete from Cart where productID = ?";
        try {
        	Connection con = super.getConnection();
	    	PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void insertCart(int accountID, int productID, int amount, String size) {
        String query = "insert Cart(accountID, productID, amount,size)\r\n"
        		+ "values(?,?,?,?)";
        try {
        	Connection con = super.getConnection();
	    	PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.setInt(3, amount);
            ps.setString(4, size);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void editAmountAndSizeCart(int accountID, int productID, int amount, String size) {
        String query = "update Cart set [amount]=?,\r\n"
        		+ "[size]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        try {
        	Connection con = super.getConnection();
	    	PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setString(2, size);
            ps.setInt(3, accountID);
            ps.setInt(4, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void editAmountCart(int accountID, int productID, int amount) {
        String query = "update Cart set [amount]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        try {
        	Connection con = super.getConnection();
	    	PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, accountID);
            ps.setInt(3, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
