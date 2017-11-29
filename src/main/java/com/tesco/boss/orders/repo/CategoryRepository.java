package com.tesco.boss.orders.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tesco.boss.orders.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer>{

		Category findByName(String name);
		
		List<Category> findBySubCategoryPresentAndId(boolean subCategoryPresent, int id);
		List<Category> findByParentCategory(int parentCategory);

		List<Category> findBySubCategoryPresentAndParentCategory(boolean b, int categoryId);

}