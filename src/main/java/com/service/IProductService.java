package com.service;

import java.util.List;

import com.entity.Product;

public interface IProductService {
	public List<Product> getAllProduct();
	public int countAllProductBySellID(int sell_ID);
	public int getSellIDByProductID(int productID);
	public int countAllProduct();
	public int getCateIDByProductID(String id);
	public Product getProductByID(String id);
	public List<Product> getTop3();
	public List<Product> getNext3Product(int amount);
	public List<Product> getProductByCID(String cid);
	public List<Product> getProductBySellIDAndIndex(int id, int indexPage);
	public List<Product> getProductByIndex(int indexPage);
	public List<Product> searchByName(String txtSearch);
	public List<Product> searchPriceUnder100();
	public List<Product> searchPrice100To200();
	public List<Product> searchColorWhite();
	public List<Product> searchColorGray();
	public List<Product> searchColorBlack();
	public List<Product> searchColorYellow();
	public List<Product> searchByPriceMinToMax(String priceMin,String priceMax);
	public List<Product> searchPriceAbove200();
	public List<Product> getRelatedProduct(int cateIDProductDetail);
	public Product getLast();
	public List<Product> get8Last();
	public void deleteProduct(String pid);
	public void deleteProductBySellID(String id);
	public void insertProduct(String name, String image, String price,
            String title, String description, String category, int sid, 
            String model, String color, String delivery, 
            String image2, String image3, String image4);
	public void editProduct(String pname, String pimage, String pprice, String ptitle, String pdescription, String pcategory, 
    		String pmodel, String pcolor, 
    		String pdelivery, String pimage2, String pimage3, String pimage4, String pid);
	public List<Product> get4NikeLast();
	public List<Product> get4AdidasLast();
	public List<Product> getNext4AdidasProduct(int amount);
	public List<Product> getNext4NikeProduct(int amount);
}
