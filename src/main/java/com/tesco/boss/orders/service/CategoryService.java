package com.tesco.boss.orders.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesco.boss.orders.domain.Category;
import com.tesco.boss.orders.repo.CategoryRepository;

@Service
public class CategoryService {
	Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	
 	@Autowired
	 private CategoryRepository categoryRepository;
	   
	public Category addCategory(Category cat){
		Category savedCategory = categoryRepository.save(cat);
		logger.info("New Category Saved with categoryId : {}",savedCategory.getId());
		return savedCategory;
	}
	   
	public List<Category> findAllChildCategories(int categoryId){
		List<Category> categories = new ArrayList<>();
		logger.info("Cateogry Id:{} ",categoryId);

		categories.add(categoryRepository.findOne(categoryId));
		if(categoryRepository.findBySubCategoryPresentAndId(true,categoryId)  != null){
			categories.addAll(findAllCategories(categoryId));
		}
		
		logger.info("Categories size is : {}",categories.size());

		return categories;
	}
	
	private List<Category> findAllCategories( int categoryId) {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findByParentCategory(categoryId).forEach(category -> {
			if(category.isSubCategoryPresent()){
				findAllCategories(category.getId());
			}
			else
			{
				categories.add(category);
			}
		});
		return categories;
	}
    
}
