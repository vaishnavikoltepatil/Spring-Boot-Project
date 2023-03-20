package com.Shop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.entity.Category;
import com.Shop.model.CategoryDTO;
import com.Shop.service.CategoryService;
import com.Shop.util.CategoryConverter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryConverter categoryconverter;
	
	@PostMapping("/createCategory")
	public String createCategory(@Valid @RequestBody CategoryDTO categoryDTO)
	{
		final Category category=categoryconverter.convertDTOToCategory(categoryDTO);
		
		return categoryService.createCategory(category);
		
	}
	@GetMapping("/getCategoryById/{categoryId}")
	public CategoryDTO getCategoryById(@PathVariable("categoryId")long categoryId)
	{
		return categoryService.getCategoryById(categoryId);
		
	}
	@GetMapping("/getAllCategory")
	public List<CategoryDTO>getAllCategory(){
		
		return categoryService.getAllCategory();
		
	}
	
	@PutMapping("/updateCategory/{categoryId}")
	public CategoryDTO updateCategory(@PathVariable("catergoryId")long categoryId,
			@Valid @RequestBody CategoryDTO categoryDTO)
	{
		Category category1= categoryconverter.convertDTOToCategory(categoryDTO);
		
		return categoryService.updateCategory(categoryId, category1);
		
	}
	
	@DeleteMapping("/deleteById/{categoryId}")
	public String deleteCategoryById(@PathVariable("categoryId")long categoreyId)
	{
		
		return categoryService.deleteCategoryById(categoreyId);
		
	}
	
	@DeleteMapping("/deleteAllCategory")
	public ResponseEntity<String>deleteAllCategory()
	{
		categoryService.deleteAllCategory();
		return new ResponseEntity<String>("All Category got deleted!",
				HttpStatus.OK);
	}
		
	@GetMapping("/getCategoryByName/{categoryName}")
	public List<CategoryDTO>getCategoryByName(@PathVariable("categoryName")String categoryName)
	{
		
		return categoryService.getCategoryByName(categoryName);
		
	}
	}


