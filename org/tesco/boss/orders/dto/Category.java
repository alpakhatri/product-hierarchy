package org.tesco.boss.orders.dto;

import java.util.ArrayList;
import java.util.Collection;

public class Category {
	
	String name;
	Collection<SubCategory> subcategories ;

	public Category(){
		
	}
	
	public Category(String name){
		this.name = name;
		subcategories = new ArrayList<SubCategory>();
	}
	
	public String getName() {
		return name;
	}

	public Collection<SubCategory> getSubcategories() {
		return subcategories;
	}


}
