package com.VendingMachine.products;

import com.VendingMachine.products.Drink;
import com.VendingMachine.Tools;

public class Water extends Drink {
	public Water() {
		super("Bottle of Water", "Bottle of Water", Double.valueOf(2.0), Tools.getValidExpirationDate(), "700 mL", false);
	}
}
