package ordering.old;
//package ordering;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.Assert;
//import org.tesco.boss.ordering.dto.Category;
//import org.tesco.boss.ordering.dto.MenuItem;
//import org.tesco.boss.ordering.dto.Product;
//import org.tesco.boss.ordering.utils.Tree;
//
//import com.google.gson.Gson;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class CheckProductAvailability {
//
//	MenuItem menuItem =null;
//	Product productToBeSearched = null;
//	Category availableCategoryForSearch = new Category("Fresh Food");
//	Tree<Product> tree = new Tree<Product>() ;
//	boolean found = false;
//	
//	Product productNotToBeFound = null;
//
//	
//	@Given("A product name and its category") 
//	public void givenProductAndCategory(){
//		productToBeSearched = new Product("Apples",30.0);
//		productNotToBeFound = new Product("Kiwi",150.0);
//		Gson gson = new Gson();
//		try (Reader reader = new FileReader("/workspace/tesco/product-hierarchy/src/test/resources/data.json")) {
//              menuItem = gson.fromJson(reader, MenuItem.class);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		} 
//	}
//	
//	@When("I search the product name in that category")
//	public void searchProduct(){
//		Stream<Category> categories = menuItem.getCategories().stream().filter(category -> category.getName().equals(availableCategoryForSearch.getName()));
//		categories.forEach(category -> 
//		{ 
//				List<Product> products = category.getSubcategories().stream().map(subCat -> subCat.getProducts()).flatMap(product -> product.stream()).collect(Collectors.toList());
//				products.forEach(product -> tree.insert(product));
//		});
//		found = tree.search(productToBeSearched);
//
//	}
//	
//	@Then("I get the product with price back")
//	public void getProductPrice(){
//		Assert.assertTrue(found);
//		
//		found = tree.search(productNotToBeFound);
//		Assert.assertFalse(found);
//	}
//}
//
