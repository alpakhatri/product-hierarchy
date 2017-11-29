//package ordering;
//
//import java.util.Map;
//
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.tesco.boss.orders.domain.Product;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//public class CheckProductAvailability {
//
//	  @Rule
//	  public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("demo-test");
//
//
//	Product toBeSearched ;
//	Product found ;
//	Map<String,Product> productByName = db.getProductsByName();
//	
//	
//	@Given("A product name and its category") 
//	public void givenProductAndCategory(){
//		toBeSearched = new Product(0,"Apples",0.0);
//	}
//	
//	@When("I search the product name in that category")
//	public void searchProduct(){
//		found = productByName.get(toBeSearched.getName());
//	}
//	
//	@Then("I get the product with price back")
//	public void getProductPrice(){
//		Assert.assertTrue(found !=null);
//		Assert.assertEquals(30.0, found.getPrice(),0);
//	}
//}
//
