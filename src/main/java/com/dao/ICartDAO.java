package com.dao;

import java.util.List;

import com.entity.Cart;

public interface ICartDAO {
	public List<Cart> getCartByAccountID(int accountID);
	public Cart checkCartExist(int accountID,int productID);
	public void deleteCartByAccountID(int accountID);
	public void deleteCartByProductID(String productID);
	public void deleteCart(int productID);
	public void insertCart(int accountID, int productID, int amount, String size);
	public void editAmountAndSizeCart(int accountID, int productID, int amount, String size);
	public void editAmountCart(int accountID, int productID, int amount);
}
