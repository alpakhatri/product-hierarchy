//package ordering;
//
//import java.util.Map;
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
//public class FindPriceAndCatergoryByProductName {
//	Product productFound ;
//	private Product productToBeSearched;
//	DBManager db = new DBManager();
//	
//	private Map<String,Product> productDetailsByName = db.getProductsByName();
//	private Map<Integer,Category> categoryDetailsById = db.getCategoriesById();
//
//	@Given("A product Name") 
//	public void givenProductAndCategory(){
//		productToBeSearched = new Product(0,"Apples",0.0);
//	}
//	
//	@When("I search name across the categories")
//	public void searchProduct(){
//		 productFound = productDetailsByName.get(productToBeSearched.getName());
//	}
//	
//	@Then("I get category and price of the product")
//	public void getProductPrice(){
//		
//		Assert.assertTrue(productFound != null );
//		Assert.assertEquals("Fresh Fruits",categoryDetailsById.get(productFound.getCategoryId()).getCategory());
//		Assert.assertEquals(30.0,productFound.getPrice(),0.0);
//
//	}
//}
