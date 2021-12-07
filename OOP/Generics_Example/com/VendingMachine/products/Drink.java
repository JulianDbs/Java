package com.VendingMachine.products;

import com.VendingMachine.products.Product;
import java.time.LocalDate;

public class Drink extends Product{
	private String milliliters;
	private boolean isHot;

	public Drink(String name, String description, Double price, LocalDate expirationDate, String milliliters, Boolean isHot) {
		super(name, description, price, expirationDate);
		this.milliliters = milliliters;
		this.isHot = isHot.booleanValue();
	}

	public String getMilliliters() {return milliliters;}

	public Boolean isHot() {return Boolean.valueOf(isHot);}

	public void warmUpDrink() {isHot = true;}
}
