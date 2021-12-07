package com.VendingMachine.products;

import com.VendingMachine.products.Food;
import com.VendingMachine.Tools;

public class CheeseSandwitch extends Food {
	public CheeseSandwitch() {
		super("Cheese Sandwitch 'Last Hour'", "Cheese Sandwitch", Double.valueOf(1.0), Tools.getValidExpirationDate(), "500 gs"); 
	}
}
