package org.tesco.boss.orders.dto;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	
	String name;
	List<Category> categories;
	
	public String getName() {
		return name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public MenuItem(){
		
	}
}
