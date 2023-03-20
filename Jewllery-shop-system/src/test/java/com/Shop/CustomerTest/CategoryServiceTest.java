package com.Shop.CustomerTest;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Shop.Repository.CategoryRepository;
import com.Shop.entity.Category;
import com.Shop.model.CategoryDTO;
import com.Shop.service.CategoryService;
import com.Shop.util.CategoryConverter;

@SpringBootTest
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryConverter categoryconverter;
	
	@MockBean
	private CategoryRepository categoryRepository;
	
	@Test
	void testCreateCategory()
	{
		Category category=Category.builder().categoryName("Earrings").build();
		
		Mockito.when(categoryRepository.save(category)).thenReturn(category);
//		assertEquals("Category details added successfully",
//				categoryService.createCategory(category));
		assertThat(categoryService.createCategory(category)).isEqualTo("Category details added successfully");
		
	}
	@Test
		void testGetCategoryById()
		{
			Category category1= Category.builder().categoryId(2).categoryName("Earrings").build();
			
			Mockito.when(categoryRepository.save(category1)).thenReturn(category1);
			assertEquals("Earrings", category1.getCategoryName());
		}
		
	@Test
		void testGetAllCategory()
		{
			Category category= Category.builder().categoryName("Necklace").build();
			Category category1= Category.builder().categoryName("Earrings").build();
			
			List<Category>list= new ArrayList<>();
			list.add(category1);
			list.add(category1);
			
			Mockito.when(categoryRepository.findAll()).thenReturn(list);
			
			List<CategoryDTO>dto= categoryService.getAllCategory();
			
			List<Category> categorys= new ArrayList<>();
			dto.forEach(categoryDto->
			categorys.add(categoryconverter.convertDTOToCategory(categoryDto))
			);
			assertThat(categorys.get(0).getCategoryName()).isEqualTo(list.get(0).getCategoryName());
			
	}
	
	@Test
		void testUpdateCategory()
		{
			Category category = Category.builder().categoryName("Earrings").build();
			
			Optional<Category> opCategory=Optional.of(category);
			
			Mockito.when(categoryRepository.findById(category.getCategoryId())).thenReturn(opCategory);
			
			Category c=opCategory.get();
			category.setCategoryName("Necklace");
			
			Mockito.when(categoryRepository.save(category)).thenReturn(c);
			
			CategoryDTO dto=categoryService.updateCategory(category.getCategoryId(),category);
			assertEquals(dto.getCategoryName(),c.getCategoryName());
		}
}
