package com.VendingMachine;

import com.VendingMachine.products.Product;
import com.VendingMachine.Purchase;
import com.VendingMachine.Ticket;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Tools {
	public static String getFormattedPrice(Double price) {
		DecimalFormat formatter = new DecimalFormat("$######.00");
		return formatter.format(price);
	}

	public static Ticket buildTicket(Purchase<? extends Product> purchase) {
		return new Ticket(purchase);
	}

	public static LocalDate getValidExpirationDate() {
		LocalDate date = LocalDate.now();
		date = date.withYear(date.getYear() + 1);
		return date;
	}
}
