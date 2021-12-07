package com.VendingMachine.products;

import com.VendingMachine.products.Candy;
import com.VendingMachine.Tools;

public class CookiesCat extends Candy {
	public CookiesCat() {
		super("Cookies Cat 'Monja'", "CookiesCat", Double.valueOf(3.0), Tools.getValidExpirationDate(), "400 gs");
	}
}
