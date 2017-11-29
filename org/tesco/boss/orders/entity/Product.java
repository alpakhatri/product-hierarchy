package org.tesco.boss.orders.entity;

public class Product{

	private int categoryId;
	private String name;
	private double price;
	private Object _id;

	public Product(){
		
	}
	public Product(int categoryId, String name, double price) {
		this.setCategoryId(categoryId);
		this.setName(name);
		this.setPrice(price);
	}
	@Override
	public String toString() {
	    return   this.getName() + " : "+this.getPrice() + " : "+ this.getCategoryId();
	}

	public int getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

}
