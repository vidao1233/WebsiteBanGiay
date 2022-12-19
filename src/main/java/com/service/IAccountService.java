package com.service;

import java.util.List;

import com.entity.Account;

public interface IAccountService {
	public List<Account> getAllAccount();
	public int checkAccountAdmin(int userID);
	public Account login(String user, String pass);
	public Account checkAccountExist(String user);
	public Account checkAccountExistByUsernameAndEmail(String username, String email);
	public void singup(String user, String pass, String email);
	public void deleteAccount(String id);
	public void insertAccount(String user, String pass, String isSell,
    		String isAdmin, String email);
	public void editProfile(String username, String password, String email, int uID);
	int countAll();
	List<Account> pagingProduct(int indexP /*số trang*/, int indexP1 /*số hiển thị trên 1 trang*/);
	void recPass(Account acc);
}
