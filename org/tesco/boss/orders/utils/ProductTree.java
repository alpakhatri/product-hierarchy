package org.tesco.boss.orders.utils;

import java.util.List;

import org.tesco.boss.orders.dto.Product;

public class ProductTree extends Tree<Product>{

	public ProductTree()
	{
		super();
	}
	
	public Product searchByName(TreeNode<Product> node, Product productToBeSearched)
	{
	      if (node == null)
	         return null;
	      else if (compare(productToBeSearched, node.data) == 0)
	      	return node.data;
	      else if (compare(productToBeSearched, node.data) < 0)
	         return searchByName(node.left, productToBeSearched);
	      else
	         return searchByName(node.right, productToBeSearched);
	}
	
	public List<Product> searchByPrice(TreeNode<Product> node, Product pricedProduct,List<Product> productsWithSamePrice)
	{
	      if (node == null)
	        return null;
	      else if (compare(pricedProduct, node.data) == 0)
	    	productsWithSamePrice.add(pricedProduct);
	      else if (compare(pricedProduct, node.data) < 0)
	        searchByPrice(node.left, pricedProduct,productsWithSamePrice);
	      else 
	        searchByPrice(node.right, pricedProduct,productsWithSamePrice);
	   return productsWithSamePrice;
	}

	public TreeNode<Product> getNode(TreeNode<Product> node, Product pricedProduct)
	{
	      if (node == null)
	        return null;
	      else if (compare(pricedProduct, node.data) == 0)
	    	return node;
	      else if (compare(pricedProduct, node.data) < 0)
	        return getNode(node.left, pricedProduct);
	      else 
	       return getNode(node.right, pricedProduct);
	}
}
