//package ordering.old;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//
//import org.junit.Assert;
//import org.tesco.boss.orders.dto.Category;
//import org.tesco.boss.orders.dto.MenuItem;
//import org.tesco.boss.orders.dto.Product;
//import org.tesco.boss.orders.utils.ProductPriceComparator;
//
//import com.google.gson.Gson;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class ListProducts {
//
//	MenuItem menuItem =null;
//	Map<Category,List<Product>> productsPerCategory = new HashMap<Category,List<Product>>();
//	
//	@Given("I have the products stored in a json") 
//	public void givenProductsByCategory(){
//		Gson gson = new Gson();
//		try (Reader reader = new FileReader("/workspace/tesco/product-hierarchy/src/test/resources/data.json")) {
//              menuItem = gson.fromJson(reader, MenuItem.class);
//              Assert.assertTrue("MenuItem is Food.","Food".equals(menuItem.getName()));
//              Assert.assertTrue("No Of Categories is 2.",( 2 == menuItem.getCategories().size()));
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		} 
//	}
//	
//	@When("I List the products")
//	public void listProducts(){
//		List<Category> categories = menuItem.getCategories();
//		categories.forEach(category -> {
//			List<Product> products = new ArrayList<Product>() ;
//			productsPerCategory.put(category, products);
//			category.getSubcategories().forEach( subCategory -> {
//				products.addAll(subCategory.getProducts());
//			});
//		});
//        Assert.assertTrue("No Of Categories is 2.",( 2 == productsPerCategory.size()));
//        Assert.assertEquals(11,productsPerCategory.get(categories.get(0)).size());
//
//	}
//	
//	
//	@Then("It should print the products sorted by price per category")
//	public void printProductsPerCategory(){
//		Set<Entry<Category,List<Product>>> entrySet = productsPerCategory.entrySet();
//		StringBuilder builder = new StringBuilder();
//		for(Entry<Category, List<Product>> entry : entrySet){
//			List<Product> products = entry.getValue();
//			Collections.sort(products,new ProductPriceComparator());
//			builder.append(entry.getKey().getName());
//			builder.append("\n");
//			entry.getValue().forEach(product -> {builder.append("\t"); builder.append(product.getName() + " - "+product.getPrice());builder.append("\n"); });
//			builder.append("\n");
//		}
//		System.out.println(builder.toString());
//	}
//}
//
