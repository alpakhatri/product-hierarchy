//package ordering;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.junit.Assert;
//import org.tesco.boss.orders.entity.Category;
//import org.tesco.boss.orders.entity.Product;
//
//import com.tesco.boss.orders.db.DBManager;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class FindProductsByPriceAndCategory {
//
//	Product productToBeSearched;
//	List<Product> productsFound = new ArrayList<>();
//	
//	DBManager db = new DBManager();
//	Map<String,Product> productByName = db.getProductsByName();
//	Map<Integer,Category> categoryDetailsById = db.getCategoriesById();
//
//	@Given("A price and a category") 
//	public void givenProductAndCategory(){
//		productToBeSearched = new Product(3,null,30.0);
//	}
//	
//	@When("I search for price in that category")
//	public void searchProduct(){
//		productsFound = productByName.values().stream().filter(product -> product.getCategoryId()==productToBeSearched.getCategoryId() && product.getPrice() <= productToBeSearched.getPrice()).collect(Collectors.toList());
//	}
//	
//	@Then("I get all the products a customer can buy in a given price")
//	public void getProductPrice(){
//		Assert.assertTrue(!productsFound.isEmpty());
//		Assert.assertEquals(3,productsFound.size());
//	}
//}
