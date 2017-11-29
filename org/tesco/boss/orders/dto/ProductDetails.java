package org.tesco.boss.orders.dto;

import java.util.List;

import org.tesco.boss.orders.dto.Product;

public class ProductDetails extends Product{
	
	public ProductDetails(int categoryId, String name, double price) {
	
		this.setCategoryId(categoryId);
	}
	
	public ProductDetails(){
		
	}
	private int categoryId;
	private Object _id;

	@Override
	public String toString() {
	    return this.get_id() +" : " + this.getName() + " : "+this.getPrice() + " : "+ this.categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

	public static List<ProductDetails> sortByPrice(List<ProductDetails> products) {
		
		if(products.size() <=0) return products;
		else
		{
			int middleIndex = products.size() / 2;
			
		}
		return null;
	}

}
