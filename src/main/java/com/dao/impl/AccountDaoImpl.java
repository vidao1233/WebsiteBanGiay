package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.context.DBContext;
import com.dao.IAccountDAO;
import com.entity.Account;

public class AccountDaoImpl extends DBContext implements IAccountDAO{
	public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                		rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
	public int checkAccountAdmin(int userID) {

        String query = "select isAdmin from Account where [uID]=?";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userID);

            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {
            	 return rs.getInt(1);
             }
        } catch (Exception e) {
        	
        }
        return 0;
    }
	public Account login(String user, String pass) {
        String query = "select * from Account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                		rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
	public Account checkAccountExist(String user) {
        String query = "select * from Account\n"
                + "where [user] = ?\n";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                		rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
	public Account checkAccountExistByUsernameAndEmail(String username, String email) {
        String query = "select * from Account where [user]=? and [email]=?";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                		rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
	public void singup(String user, String pass, String email) {
        String query = "insert into Account\n"
                + "values(?,?,0,0,?)";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void deleteAccount(String id) {
        String query = "delete from Account where uID= ?";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void insertAccount(String user, String pass, String isSell,
    		String isAdmin, String email) {
        String query = "insert Account([user], pass, isSell, isAdmin, email)\r\n"
        		+ "values(?,?,?,?,?)";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, isSell);
            ps.setString(4, isAdmin);
            ps.setString(5, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
	public void editProfile(String username, String password, String email, int uID) {
        String query = "update Account set [user]=?,\r\n"
        		+ "[pass]=?,\r\n"
        		+ "[email]=?\r\n"
        		+ "where [uID] = ?";
        try {
        	Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, uID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
