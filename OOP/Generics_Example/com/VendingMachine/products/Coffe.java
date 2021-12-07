package com.VendingMachine.products;

import com.VendingMachine.products.Drink;
import com.VendingMachine.Tools;

public class Coffe extends Drink {
	public Coffe() {
		super(
			"Coffe", "Coffe", Double.valueOf(1.0), Tools.getValidExpirationDate(), "200 mL", true
		);
	}
}
