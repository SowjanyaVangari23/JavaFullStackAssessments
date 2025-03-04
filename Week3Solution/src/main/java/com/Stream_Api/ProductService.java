package com.Stream_Api;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
	  public Product getHighestPricedProduct(List<Product> products) {
	        return products.stream()
	                .max(Comparator.comparing(Product::getPrice))
	                .orElse(null);
	    }
	    public Product getLowestPricedProduct(List<Product> products) {
	        return products.stream()
	                .min(Comparator.comparing(Product::getPrice))
	                .orElse(null);
	    }
	    public List<Product> getExpiredProducts(List<Product> products) {
	        LocalDate currentDate = LocalDate.now();
	        return products.stream()
	                .filter(product -> product.getExpiryDate().isBefore(currentDate))
	                .collect(Collectors.toList());
	    }
	    public List<String> getProductsExpiringInNext10Days(List<Product> products) {
	        LocalDate currentDate = LocalDate.now();
	        LocalDate tenDaysLater = currentDate.plusDays(10);
	        
	        return products.stream()
	                .filter(product -> !product.getExpiryDate().isBefore(currentDate) && product.getExpiryDate().isBefore(tenDaysLater))
	                .map(Product::getName)
	                .collect(Collectors.toList());
	    }
	    public Map<String, Long> getProductCountByType(List<Product> products) {
	        return products.stream()
	                .collect(Collectors.groupingBy(Product::getType, Collectors.counting()));
	    }

	    public Map<String, Long> getProductCountBySupplier(List<Product> products) {
	        //return products.stream().collect(Collectors.groupingBy(product -> product.getSupplier().getSname(), Collectors.counting()));
	        return products.stream().collect(Collectors.groupingBy(x->x.type,Collectors.counting()));
	    }

}
