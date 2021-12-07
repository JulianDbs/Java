package com.VendingMachine.products;

import com.VendingMachine.products.Drink;
import com.VendingMachine.Tools;

public class YodaSoda extends Drink {
	public YodaSoda() {
		super("YodaSoda", "Don't Ask", Double.valueOf(3.5), Tools.getValidExpirationDate(), "700 mL", false);
	}
}
