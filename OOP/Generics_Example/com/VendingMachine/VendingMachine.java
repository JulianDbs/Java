package com.VendingMachine;

import com.VendingMachine.UserConsole;
import com.VendingMachine.products.*;
import com.VendingMachine.Purchase;
import com.VendingMachine.Ticket;
import com.VendingMachine.Tools;
import java.lang.StringBuilder;

public class VendingMachine implements UserConsole {
	public VendingMachine() {US_start();}

	@Override
	public void US_processPurchase(Purchase<? extends Product> p) {
		this.clearScreen();
		if (p.getPurchaseType().equals("drink")) {
			processDrink(p.toDrink());
		}
		deliverProduct(p, Tools.buildTicket(p));
	}

	private <T extends Drink> void processDrink(T t) {
		switch(t.getName()) {
			case "Coffe": case "Tea":
				t.warmUpDrink();
			break;
			default: break;
		}
	}

	private void deliverProduct(Purchase<? extends Product> p, Ticket ticket) {
		System.out.format(ticket.getContent().toString());
	}
}
