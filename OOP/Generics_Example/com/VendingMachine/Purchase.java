package com.VendingMachine;

import com.VendingMachine.products.*;
import com.VendingMachine.Tools;
import java.util.HashMap;

public class Purchase <T extends Product> {
	private T product;

	public Purchase(T product) {this.product = product;}

	public T getProduct() {return product;}

	public String getPurchaseType() {return product.getClass().getSimpleName();}

	public Drink toDrink() {if (getPurchaseType().equals("drink")) {return (Drink) product;} else {return null;}}

	public Food toFood() {if (getPurchaseType().equals("food")) {return (Food) product;} else {return null;}}

	public Candy toCandy() {if (getPurchaseType().equals("candy")) {return (Candy) product;} else {return null;}}

	public HashMap<String, String> getInfo() {
		HashMap<String, String> info = new HashMap<>();
		info.put("name", product.getName());
		info.put("description", product.getDescription());
		info.put("price", Tools.getFormattedPrice(product.getPrice()));
		info.put("expiration", product.getExpirationDate());
		switch(this.getPurchaseType()) {
			case "drink":
				Drink drink = (Drink) product;
				info.put("milliliters", drink.getMilliliters());
			break;
			case "food":
				Food food = (Food) product;
				info.put("grams", food.getGrams());
			break;
			case "candy":
				Candy candy = (Candy) product;
				info.put("grams", candy.getGrams());
			break;
		}
		return info;
	}

}
