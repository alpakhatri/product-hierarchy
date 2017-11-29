package com.tesco.boss.orders.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.boss.orders.domain.Category;
import com.tesco.boss.orders.domain.Product;
import com.tesco.boss.orders.service.CategoryService;
import com.tesco.boss.orders.service.ProductService;

@RestController
@RequestMapping("/v1/orders/")
@Consumes(MediaType.APPLICATION_JSON_VALUE)
@Produces(MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {
  
	private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);
    
	
    private final CategoryService categoryService;
	
	private final ProductService productService;


    @Autowired
    public OrdersController(ProductService productService,CategoryService categoryService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @RequestMapping(path="/product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Product create(@RequestBody @Valid Product product) {
        LOGGER.info("Creating a new product with information: {}", product);

        Product created = productService.create(product);
        LOGGER.info("Created a new product with information: {}", created);
        return created;
    }
    
    @RequestMapping(path="/category", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Category create(@RequestBody @Valid Category category) {
        LOGGER.info("Creating a new category with information: {}", category);
        Category created = categoryService.addCategory(category);
        LOGGER.info("Created a new category with information: {}", created);
        return created;
    }
    
    
    @RequestMapping(path="/category/{categoryId}/product/{name}", method = RequestMethod.GET)
    List<Product> findByProductNameUnderCategory(@PathVariable("categoryId") String categoryId,@PathVariable("name") String name) {
    	int catId = Integer.parseInt(categoryId);
    	LOGGER.info("Finding Product with category id: {} and product name : {}", categoryId,name);
    	List<Category> categories = categoryService.findAllChildCategories(catId);
        List<Product> products = productService.findByProductNameForCategories(name,categories);
        LOGGER.info("Found {} Products", products.size());

        return products;
    }
    
    @RequestMapping(path="/products/name/{name}", method = RequestMethod.GET)
    List<Product> findProductsMatchingName(@PathVariable("name") String name) {
    	LOGGER.info("Finding Product with product name : {}",name);
        List<Product> products = productService.findProductByName(name);
        LOGGER.info("Found Products: {}", products.size());
        return products;
    }
    
    @RequestMapping(path="/product/name/{name}", method = RequestMethod.GET)
    Map<String,Double> findProductPriceByName(@PathVariable("name") String name) {
    	LOGGER.info("Finding Product with product name : {}",name);
    	Map<String,Double> products = productService.findProductPriceByName(name);
        LOGGER.info("Found Product with information: {}", products);
        return products;
    }
    
    @RequestMapping(path="/products/price/{price}/category/{categoryId}", method = RequestMethod.GET)
    List<Product> findProductsForPriceAndCategory(@PathVariable("price") String price, @PathVariable("categoryId") String categoryId) {
    	List<Category> categories = categoryService.findAllChildCategories(Integer.parseInt(categoryId));

    	LOGGER.info("Finding Products with product price : {}",price);
        List<Product> products = productService.findProductForPrice(Double.parseDouble(price),categories);
        LOGGER.info("Found Products: {}", products.size());
        return products;
    }
    
    @RequestMapping(path="/products/id/{id}", method = RequestMethod.GET)
    Product findById(@PathVariable("id") String id) {
        LOGGER.info("Finding Product with id: {}", id);

        Product product = productService.findById(Integer.parseInt(id));
        LOGGER.info("Found Product with information: {}", product);
        return product;
    }
    
    
    @RequestMapping(path="/products", method = RequestMethod.GET)
    List<List<Product>> findAllProductsSortedByPrice() {
        
        return null;
    }
    
    @RequestMapping(path="/products/price/{price}", method = RequestMethod.GET)
    List<List<Product>> findAllProductCombinations(@PathVariable("price") String price) {
        LOGGER.info("Finding Product with price: {}", price);
        
        return null;
    }
    @RequestMapping(path="/_status", method = RequestMethod.GET)
    String checkAPIStatus() {
    	return "API is up and running";
    }
}
