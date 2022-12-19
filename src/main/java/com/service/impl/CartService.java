package com.service.impl;

import java.util.List;

import com.dao.ICartDAO;
import com.dao.impl.CartDaoImpl;
import com.entity.Cart;
import com.service.ICartService;

public class CartService implements ICartService{
	
	ICartDAO crt = new CartDaoImpl();

	@Override
	public List<Cart> getCartByAccountID(int accountID) {
		// TODO Auto-generated method stub
		return crt.getCartByAccountID(accountID);
	}

	@Override
	public Cart checkCartExist(int accountID, int productID) {
		// TODO Auto-generated method stub
		return crt.checkCartExist(accountID, productID);
	}

	@Override
	public void deleteCartByAccountID(int accountID) {
		// TODO Auto-generated method stub
		crt.deleteCartByAccountID(accountID);
	}

	@Override
	public void deleteCartByProductID(String productID) {
		// TODO Auto-generated method stub
		crt.deleteCartByProductID(productID);
	}

	@Override
	public void deleteCart(int productID) {
		// TODO Auto-generated method stub
		crt.deleteCart(productID);
	}

	@Override
	public void insertCart(int accountID, int productID, int amount, String size) {
		// TODO Auto-generated method stub
		crt.insertCart(accountID, productID, amount, size);
	}

	@Override
	public void editAmountAndSizeCart(int accountID, int productID, int amount, String size) {
		// TODO Auto-generated method stub
		crt.editAmountAndSizeCart(accountID, productID, amount, size);
	}

	@Override
	public void editAmountCart(int accountID, int productID, int amount) {
		// TODO Auto-generated method stub
		crt.editAmountCart(accountID, productID, amount);
	}

}
