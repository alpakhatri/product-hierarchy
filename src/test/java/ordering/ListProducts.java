//package ordering;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.tesco.boss.orders.entity.Category;
//import org.tesco.boss.orders.entity.Product;
//import org.tesco.boss.orders.utils.ProductPriceComparator;
//
//import com.tesco.boss.orders.db.DBManager;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class ListProducts {
//
//	List<Product> products;
//	List<Product> sortedProducts;
//	
//	DBManager db = new DBManager();
//
//	private Map<String,Product> productDetailsByName = db.getProductsByName();
//	private Map<Integer,Category> categoryDetailsById = db.getCategoriesById();
//
//	@Given("I have the products") 
//	public void givenProductsByCategory(){
//		products = (List<Product>) productDetailsByName.values();
//	}
//	
//	@When("I List the products")
//	public void listProducts(){
//		sortedProducts = products.stream().sorted(new ProductPriceComparator()).collect(Collectors.toList());
//	}
//	
//	
//	@Then("It should print the products sorted by price per category")
//	public void printProductsPerCategory(){
//		sortedProducts.stream().forEach(product -> System.out.println(categoryDetailsById.get(product.getCategoryId()).getCategory() +" : "+product.getName()+" : "+product.getPrice()));
//	}
//}
//
