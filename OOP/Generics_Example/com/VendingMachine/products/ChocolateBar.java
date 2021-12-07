package com.VendingMachine.products;

import com.VendingMachine.products.Candy;
import com.VendingMachine.Tools;

public class ChocolateBar extends Candy {
	public ChocolateBar() {
		super("Chocolate Bar 'WonkaKiller'", "Chocolate Bar", Double.valueOf(1.5), Tools.getValidExpirationDate(), "200 gs");
	}
}
