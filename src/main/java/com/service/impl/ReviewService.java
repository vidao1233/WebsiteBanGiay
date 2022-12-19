package com.service.impl;

import java.util.List;

import com.dao.IReviewDAO;
import com.dao.impl.ReviewDaoImpl;
import com.entity.Review;
import com.service.IReviewService;

public class ReviewService implements IReviewService{

	IReviewDAO rev = new ReviewDaoImpl();
	
	@Override
	public int countAllReview() {
		// TODO Auto-generated method stub
		return rev.countAllReview();
	}

	@Override
	public List<Review> getAllReviewByProductID(String productId) {
		// TODO Auto-generated method stub
		return rev.getAllReviewByProductID(productId);
	}

	@Override
	public Review getNewReview(int accountID, int productID) {
		// TODO Auto-generated method stub
		return rev.getNewReview(accountID, productID);
	}

	@Override
	public void deleteReviewByProductID(String productID) {
		// TODO Auto-generated method stub
		rev.deleteReviewByProductID(productID);
	}

	@Override
	public void deleteReviewByAccountID(String id) {
		// TODO Auto-generated method stub
		rev.deleteReviewByAccountID(id);
	}

	@Override
	public void insertReview(int accountID, int productID, String contentReview) {
		// TODO Auto-generated method stub
		rev.insertReview(accountID, productID, contentReview);
	}

}
