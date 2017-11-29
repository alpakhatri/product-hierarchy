//package ordering;
//
//import java.util.HashMap;
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
//public class FindAllPossibleProductsInAGivenPrice {
//	//10,20,30,40,50,60 | 60 : {10,20,30},{20,40},{10,50},{60}
//	
//	DBManager db = new DBManager();
//	private Map<String,Product> productDetailsByName = db.getProductsByName();
//	private Map<Integer,Category> categoryDetailsById;
//
//	Double budget;
//	Map<Integer,List<Product>> productsFoundByCombination = new HashMap<>();
//	
//	@Given("the budget of the customer and categories to search for the products") 
//	public void givenProductAndCategory(){
//	  budget =50.0 ;
//	  categoryDetailsById.put(4, new Category(4,"Fresh Vegetables",3));
//	  categoryDetailsById.put(7,new Category(7,"Doughnuts, Cookies & Muffins",5));
//	}
//	
//	@When("I search combinations of products can be bought in that price")
//	public void searchProduct(){
//		
//		
//		List<Product> sortedProducts = productDetailsByName.values().stream().filter(product -> categoryDetailsById.containsKey(product.getCategoryId())  && product.getPrice() <= budget).sorted(new ProductPriceComparator()).collect(Collectors.toList());
//		productsFoundByCombination = getAllProductCombinationsInTheBudget(sortedProducts);
//	}
//	
//	private Map<Integer, List<Product>> getAllProductCombinationsInTheBudget(List<Product> sortedProducts) {
//		
//		return null;
//	}
//
//	@Then("I get all products I can buy")
//	public void getProductPrice(){
//		
//	}
//}
