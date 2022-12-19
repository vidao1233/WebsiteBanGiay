package com.service;

import java.util.List;

import com.entity.Review;

public interface IReviewService {
	public int countAllReview();
	public List<Review> getAllReviewByProductID(String productId);
	public Review getNewReview(int accountID, int productID);
	public void deleteReviewByProductID(String productID);
	public void deleteReviewByAccountID(String id);
	public void insertReview(int accountID, int productID, String contentReview);
}
