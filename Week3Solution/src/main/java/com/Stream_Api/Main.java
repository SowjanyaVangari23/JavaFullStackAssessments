package com.Stream_Api;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
public class Main {
	 public static void main(String[] args) {
	        Supplier supplier1 = new Supplier(1, "Supplier A");
	        Supplier supplier2 = new Supplier(2, "Supplier B");

	        Product product1 = new Product(1, "Milk", "Dairy", 100.0, 5.0, LocalDate.of(2025, 3, 15), supplier1);
	        Product product2 = new Product(2, "Rice", "Pulses", 50.0, 3.5, LocalDate.of(2025, 4, 10), supplier2);
	        Product product3 = new Product(3, "Cheese", "Dairy", 70.0, 10.0, LocalDate.of(2025, 2, 25), supplier1);
	        Product product4 = new Product(4, "Chips", "Snacks", 30.0, 2.0, LocalDate.of(2025, 3, 20), supplier2);

	        List<Product> products = Arrays.asList(product1, product2, product3, product4);

	        ProductService productService = new ProductService();
	        System.out.println("List of Products:");
	        System.out.println(products);
	        System.out.println("Highest Priced Product: " + productService.getHighestPricedProduct(products).getName());
	        System.out.println("Lowest Priced Product: " + productService.getLowestPricedProduct(products).getName());
	        System.out.println("Expired Products: " + productService.getExpiredProducts(products).size());
	        System.out.println("Products Expiring in Next 10 Days: " + productService.getProductsExpiringInNext10Days(products));
	        System.out.println("Product Count by Type: " + productService.getProductCountByType(products));
	        System.out.println("Product Count by Supplier: " + productService.getProductCountBySupplier(products));
	    }

}
