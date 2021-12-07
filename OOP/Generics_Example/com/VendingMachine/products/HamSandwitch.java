package com.VendingMachine.products;

import com.VendingMachine.products.Food;
import com.VendingMachine.Tools;

public class HamSandwitch extends Food {
	public HamSandwitch() {
		super("Ham Sandwitch 'Lecter'", "Ham Sandwitch", Double.valueOf("10.0"), Tools.getValidExpirationDate(), "500 gs");
	}
}
