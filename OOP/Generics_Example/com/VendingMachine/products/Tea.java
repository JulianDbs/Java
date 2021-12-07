package com.VendingMachine.products;

import com.VendingMachine.products.Drink;
import com.VendingMachine.Tools;

public class Tea extends Drink {
	public Tea() {
		super("Tea", "Tea", Double.valueOf(1.0), Tools.getValidExpirationDate(), "200 mL", true);
	}
}
