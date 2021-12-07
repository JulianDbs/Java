package com.VendingMachine.products;

import java.time.LocalDate;

public class Product{
	private String name;
	private String description;
	private double price;
	private LocalDate expirationDate;

	public Product(String name, String description, Double price, LocalDate expirationDate) {
		this.name = name;
		this.description = description;
		this.price = price.doubleValue();
		this.expirationDate = expirationDate;
	}

	public String getName() {return name;}

	public String getDescription() {return description;}

	public Double getPrice() {return Double.valueOf(price);}

	public String getExpirationDate() {
		return expirationDate.format( java.time.format.DateTimeFormatter.ofLocalizedDate(java.time.format.FormatStyle.MEDIUM));
	}
}
