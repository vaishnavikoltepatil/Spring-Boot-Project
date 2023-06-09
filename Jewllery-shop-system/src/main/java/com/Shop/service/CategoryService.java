package com.Shop.service;

import java.util.List;


import com.Shop.entity.Category;
import com.Shop.model.CategoryDTO;

public interface CategoryService {

	String createCategory(Category category);
	CategoryDTO getCategoryById(long categoryId);
	
	List<CategoryDTO>getAllCategory();
	CategoryDTO updateCategory(long categoryId, Category category);
	
	String deleteCategoryById(long categoryId);
	void deleteAllCategory();
	
	List<CategoryDTO>getCategoryByName(String categoryName);
	
}
