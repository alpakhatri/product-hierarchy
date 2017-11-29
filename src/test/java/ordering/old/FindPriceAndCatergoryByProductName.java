package ordering.old;
//package ordering;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Assert;
//import org.tesco.boss.ordering.dto.Category;
//import org.tesco.boss.ordering.dto.MenuItem;
//import org.tesco.boss.ordering.dto.Product;
//import org.tesco.boss.ordering.utils.ProductNameComparator;
//import org.tesco.boss.ordering.utils.ProductTree;
//
//import com.google.gson.Gson;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class FindPriceAndCatergoryByProductName {
//
//	MenuItem menuItem =null;
//	Product productToBeSearched = null;
//	ProductTree tree = new ProductTree() ;
//
//	Map<Category,List<Product>> productsByCategory = new HashMap<Category,List<Product>>();
//
//	Category foundCategory = null;
//	Product foundProduct = null;
//	
//	@Given("A product Name") 
//	public void givenProductAndCategory(){
//		Gson gson = new Gson();
//		try (Reader reader = new FileReader("/workspace/tesco/product-hierarchy/src/test/resources/data.json")) {
//              menuItem = gson.fromJson(reader, MenuItem.class);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		} 
//		productToBeSearched = new Product("Apples",0.0);
//		 tree.setComparator(new ProductNameComparator());
//
//	}
//	
//	@When("I search name across the categories")
//	public void searchProduct(){
//		List<Product> allproducts = new ArrayList<>();
//		menuItem.getCategories().stream().forEach(category -> 
//		{ 
//				if(productsByCategory.get(category) == null)
//					productsByCategory.put(category, new ArrayList<>());
//				category.getSubcategories().stream().map(subCat -> subCat.getProducts()).flatMap(products -> products.stream()).forEach(product -> { productsByCategory.get(category).add(product); allproducts.add(product);});
//				allproducts.forEach(product -> tree.insert(product));
//		});
//		tree.inOrderTraversal();
//		foundProduct = tree.searchByName(tree.getRoot(), productToBeSearched);
//		productsByCategory.forEach((category, products) -> {
//			if(products.contains(foundProduct)){
//				foundCategory = category;
//			}
//		});
//	}
//	
//	@Then("I get category and price of the product")
//	public void getProductPrice(){
//		
//		Assert.assertTrue(foundProduct != null && foundCategory !=null);
//		Assert.assertEquals("Fresh Food",foundCategory.getName());
//		Assert.assertEquals(30.0,foundProduct.getPrice(),0.0);
//
//	}
//}
