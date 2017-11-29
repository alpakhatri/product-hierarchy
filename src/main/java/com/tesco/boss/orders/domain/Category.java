package com.tesco.boss.orders.domain;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Category")
public class Category {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
	 
	 private String name;
	
	 private int parentCategory;
	
	 private boolean subCategoryPresent;
	
	protected Category(){
		
	}
	
	public Category(String name, int parentCategory,boolean subCategoryPresent){
		this.setName(name);
		this.setParentCategory(parentCategory);
		this.setSubCategoryPresent(subCategoryPresent);
	}
	
	public int getId() {
		return id;
	}

	public int getParentCategory() {
		return parentCategory;
	}
	
	private void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	}

	public boolean isSubCategoryPresent() {
		return subCategoryPresent;
	}

	private void setSubCategoryPresent(boolean subCategoryPresent) {
		this.subCategoryPresent = subCategoryPresent;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
}
