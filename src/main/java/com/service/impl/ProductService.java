package com.service.impl;

import java.util.List;

import com.dao.IProductDAO;
import com.dao.impl.ProductDaoImpl;
import com.entity.Product;
import com.service.IProductService;

public class ProductService implements IProductService{

	IProductDAO prod = new ProductDaoImpl();
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return prod.getAllProduct();
	}

	@Override
	public int countAllProductBySellID(int sell_ID) {
		// TODO Auto-generated method stub
		return prod.countAllProductBySellID(sell_ID);
	}

	@Override
	public int getSellIDByProductID(int productID) {
		// TODO Auto-generated method stub
		return prod.getSellIDByProductID(productID);
	}

	@Override
	public int countAllProduct() {
		// TODO Auto-generated method stub
		return prod.countAllProduct();
	}

	@Override
	public int getCateIDByProductID(String id) {
		// TODO Auto-generated method stub
		return prod.getCateIDByProductID(id);
	}

	@Override
	public List<Product> getTop3() {
		// TODO Auto-generated method stub
		return prod.getTop3();
	}

	@Override
	public List<Product> getNext3Product(int amount) {
		// TODO Auto-generated method stub
		return prod.getNext3Product(amount);
	}

	@Override
	public List<Product> getProductByCID(String cid) {
		// TODO Auto-generated method stub
		return prod.getProductByCID(cid);
	}

	@Override
	public List<Product> getProductBySellIDAndIndex(int id, int indexPage) {
		// TODO Auto-generated method stub
		return prod.getProductBySellIDAndIndex(id, indexPage);
	}

	@Override
	public List<Product> getProductByIndex(int indexPage) {
		// TODO Auto-generated method stub
		return prod.getProductByIndex(indexPage);
	}

	@Override
	public List<Product> searchByName(String txtSearch) {
		// TODO Auto-generated method stub
		return prod.searchByName(txtSearch);
	}

	@Override
	public List<Product> searchPriceUnder100() {
		// TODO Auto-generated method stub
		return prod.searchPriceUnder100();
	}

	@Override
	public List<Product> searchPrice100To200() {
		// TODO Auto-generated method stub
		return prod.searchPrice100To200();
	}

	@Override
	public List<Product> searchColorWhite() {
		// TODO Auto-generated method stub
		return prod.searchColorWhite();
	}

	@Override
	public List<Product> searchColorGray() {
		// TODO Auto-generated method stub
		return prod.searchColorGray();
	}

	@Override
	public List<Product> searchColorBlack() {
		// TODO Auto-generated method stub
		return prod.searchColorBlack();
	}

	@Override
	public List<Product> searchColorYellow() {
		// TODO Auto-generated method stub
		return prod.searchColorYellow();
	}

	@Override
	public List<Product> searchByPriceMinToMax(String priceMin, String priceMax) {
		// TODO Auto-generated method stub
		return prod.searchByPriceMinToMax(priceMin, priceMax);
	}

	@Override
	public List<Product> searchPriceAbove200() {
		// TODO Auto-generated method stub
		return prod.searchPriceAbove200();
	}

	@Override
	public List<Product> getRelatedProduct(int cateIDProductDetail) {
		// TODO Auto-generated method stub
		return prod.getRelatedProduct(cateIDProductDetail);
	}

	@Override
	public Product getLast() {
		// TODO Auto-generated method stub
		return prod.getLast();
	}

	@Override
	public List<Product> get8Last() {
		// TODO Auto-generated method stub
		return prod.get8Last();
	}

	@Override
	public void deleteProduct(String pid) {
		// TODO Auto-generated method stub
		prod.deleteProduct(pid);
	}

	@Override
	public void deleteProductBySellID(String id) {
		// TODO Auto-generated method stub
		prod.deleteProductBySellID(id);
	}

	@Override
	public void insertProduct(String name, String image, String price, String title, String description,
			String category, int sid, String model, String color, String delivery, String image2, String image3,
			String image4) {
		// TODO Auto-generated method stub
		prod.insertProduct(name, image, price, title, description, category, sid, model, color, delivery, image2, image3, image4);
	}

	@Override
	public void editProduct(String pname, String pimage, String pprice, String ptitle, String pdescription,
			String pcategory, String pmodel, String pcolor, String pdelivery, String pimage2, String pimage3,
			String pimage4, String pid) {
		// TODO Auto-generated method stub
		prod.editProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, pmodel, pcolor, pdelivery, pimage2, pimage3, pimage4, pid);
	}

	@Override
	public List<Product> get4NikeLast() {
		// TODO Auto-generated method stub
		return prod.get4NikeLast();
	}

	@Override
	public List<Product> get4AdidasLast() {
		// TODO Auto-generated method stub
		return prod.get4AdidasLast();
	}

	@Override
	public Product getProductByID(String id) {
		// TODO Auto-generated method stub
		return prod.getProductByID(id);
	}

	@Override
	public List<Product> getNext4AdidasProduct(int amount) {
		// TODO Auto-generated method stub
		return prod.getNext4AdidasProduct(amount);
	}

	@Override
	public List<Product> getNext4NikeProduct(int amount) {
		// TODO Auto-generated method stub
		return prod.getNext4NikeProduct(amount);
	}

	@Override
	public List<Product> getByOItem(int id) {
		// TODO Auto-generated method stub
		return prod.getByOItem(id);
	}

}
