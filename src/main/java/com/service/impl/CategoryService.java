package com.service.impl;

import java.util.List;

import com.dao.ICategoryDAO;
import com.dao.impl.CategoryDaoImpl;
import com.entity.Category;
import com.service.ICategoryService;

public class CategoryService implements ICategoryService{

	ICategoryDAO cate = new CategoryDaoImpl();
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return cate.getAllCategory();
	}

}
