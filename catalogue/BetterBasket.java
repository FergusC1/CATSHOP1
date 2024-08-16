package catalogue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BetterBasket extends Basket and uses a map to manage products.
 * It allows adding products and updating quantities if the product already exists.
 * 
 * @author  Fergus Chamberlain 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Map<String, Product> productMap;
  private Product lastProduct;
  
  public BetterBasket() {
	    super(); // initialises basket part of the class
	    productMap = new HashMap<>();

  
}  

  /**
   * Adds a product to the basket or updates the quantity if the product already exists.
   * 
   * @param pr the product to be added or updated
   * @return true if the product was successfully added or updated, false otherwise
   */
  
  @Override
  public boolean add(Product pr) {
	  String productNum = pr.getProductNum(); // Get the product number from the product
	  if (productMap.containsKey(pr.getProductNum())) { // Update existing product
		  Product existingProduct = productMap.get(pr.getProductNum());
		  existingProduct.setQuantity(existingProduct.getQuantity() + pr.getQuantity());
  }
	  else { // Add new product if not the same
          productMap.put(productNum, pr);
      }
      lastProduct = pr; // Update lastProduct with the most recent product
      
      // Sort the products and update the collection in the superclass
      return sortAndUpdate();
  }

  /**
   * Sorts the products by their product number and updates the collection in the superclass.
   * 
   * @return true if sorting and updating were successful
   */
  private boolean sortAndUpdate() {
      // Convert productMap values to a list
      List<Product> productList = new ArrayList<>(productMap.values());

      // Sort the list by product number
      Collections.sort(productList, Comparator.comparing(Product::getProductNum));

      // Clear the collection in the superclass and add sorted products
      super.clear();
      super.addAll(productList);

      return true; // Indicate success
  }

  
}




