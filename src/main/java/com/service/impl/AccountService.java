package com.service.impl;

import java.util.List;

import com.dao.IAccountDAO;
import com.dao.impl.AccountDaoImpl;
import com.entity.Account;
import com.service.IAccountService;

public class AccountService implements IAccountService{
	
	IAccountDAO acc = new AccountDaoImpl();

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return acc.getAllAccount();
	}

	@Override
	public int checkAccountAdmin(int userID) {
		// TODO Auto-generated method stub
		return acc.checkAccountAdmin(userID);
	}

	@Override
	public Account login(String user, String pass) {
		// TODO Auto-generated method stub
		return acc.login(user, pass);
	}

	@Override
	public Account checkAccountExist(String user) {
		// TODO Auto-generated method stub
		return acc.checkAccountExist(user);
	}

	@Override
	public Account checkAccountExistByUsernameAndEmail(String username, String email) {
		// TODO Auto-generated method stub
		return acc.checkAccountExistByUsernameAndEmail(username, email);
	}

	@Override
	public void singup(String user, String pass, String email) {
		acc.singup(user, pass, email);
		
	}

	@Override
	public void deleteAccount(String id) {
		// TODO Auto-generated method stub
		acc.deleteAccount(id);
	}

	@Override
	public void insertAccount(String user, String pass, String isSell, String isAdmin, String email) {
		// TODO Auto-generated method stub
		acc.insertAccount(user, pass, isSell, isAdmin, email);
	}

	@Override
	public void editProfile(String username, String password, String email, int uID) {
		// TODO Auto-generated method stub
		acc.editProfile(username, password, email, uID);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return acc.countAll();
	}

	@Override
	public List<Account> pagingProduct(int indexP, int indexP1) {
		// TODO Auto-generated method stub
		return acc.pagingProduct(indexP, indexP1);
	}

}
