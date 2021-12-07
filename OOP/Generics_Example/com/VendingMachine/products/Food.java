package com.VendingMachine.products;

import com.VendingMachine.products.Product;
import java.time.LocalDate;

public class Food extends Product {
	private String grams;
	public Food(String name, String description, Double price, LocalDate expirationDate, String grams) {
		super(name, description, price, expirationDate);
		this.grams = grams;
	}

	public String getGrams() {return grams;}
}
