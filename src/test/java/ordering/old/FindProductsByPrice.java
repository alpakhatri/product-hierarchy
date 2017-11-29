package ordering.old;
//package ordering;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.Assert;
//import org.tesco.boss.ordering.dto.Category;
//import org.tesco.boss.ordering.dto.MenuItem;
//import org.tesco.boss.ordering.dto.Product;
//import org.tesco.boss.ordering.utils.ProductPriceComparator;
//import org.tesco.boss.ordering.utils.ProductTree;
//
//import com.google.gson.Gson;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class FindProductsByPrice {
//
//	MenuItem menuItem =null;
//	Product productToBeSearched = null;
//	
//	Category availableCategoryForSearch = null;
//	ProductTree tree = new ProductTree() ;
//	List<Product> productsFound = new ArrayList<>();
//	
//	Product productNotToBeFound = null;
//
//	
//	@Given("A price and a category") 
//	public void givenProductAndCategory(){
//		Gson gson = new Gson();
//		try (Reader reader = new FileReader("/workspace/tesco/product-hierarchy/src/test/resources/data.json")) {
//              menuItem = gson.fromJson(reader, MenuItem.class);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		} 
//		availableCategoryForSearch = new Category("Fresh Food");
//		productToBeSearched = new Product(null,30.0);
//		 tree.setComparator(new ProductPriceComparator());
//
//	}
//	
//	@When("I search for price in that category")
//	public void searchProduct(){
//		Stream<Category> categories = menuItem.getCategories().stream().filter(category -> category.getName().equals(availableCategoryForSearch.getName()));
//		categories.forEach(category -> 
//		{ 
//				List<Product> products = category.getSubcategories().stream().map(subCat -> subCat.getProducts()).flatMap(product -> product.stream()).collect(Collectors.toList());
//				products.forEach(product -> tree.insert(product));
//		});
//		tree.inOrderTraversal();
//		productsFound = tree.searchByPrice(tree.getRoot(),productToBeSearched,productsFound);
//
//	}
//	
//	@Then("I get all the products with same price")
//	public void getProductPrice(){
//		
//		Assert.assertTrue(!productsFound.isEmpty());
//		Assert.assertEquals(1,productsFound.size());
//	}
//}
