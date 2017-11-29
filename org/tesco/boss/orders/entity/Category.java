package org.tesco.boss.orders.entity;

public class Category {
	private Object _id;

	
	private int id;
	private String category;
	private int parentCategory;
	
	public Category(){
		
	}
	
	public Category(int id, String name, int parentCategory){
		this.setCategory(name);
		this.setId(id);
		this.setParentCategory(parentCategory);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	public Object get_id() {
		return _id;
	}
	public void set_id(Object _id) {
		this._id = _id;
	}
}
