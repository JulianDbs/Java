
package com.VendingMachine;

import java.lang.StringBuilder;
import java.util.HashMap;
import com.VendingMachine.Purchase;
import com.VendingMachine.Tools;
import com.VendingMachine.products.Product;

public class Ticket {
	private StringBuilder content;
	private final static String ticketTitle = "|\t\t\tVending Machine VM-800\t\t\t|%n";
	private final static String ticketMessage = "|\t\t\tThanks for Your Purchase\t\t|%n";
	private final static String startLine = "|\t";
	private final static String endLine = "\t\t|%n";
	private final static String emptyLine = "|\t\t\t\t\t\t\t\t|%n";
	private final static String codeBar = "\t│║█│█║║│█│██│║│║█│║█│█║│█│██│║█│█║█";

	public Ticket(Purchase<? extends Product> purchase) {
		content = new StringBuilder();
		processProduct(purchase.getInfo());
	}

	private void processProduct(HashMap<String, String> info) {
		content	.append(emptyLine)
			.append(ticketTitle)
			.append(emptyLine)
			.append(startLine);
		String n = info.get("name");
		if (n.length() <=16) {content.append("\t");}
		content
			.append(n)
			.append(" (")
			.append(info.get("expiration"))
			.append(")");
		if (n.length() <= 14) {content.append("\t\t");}
		else if (n.length() >14 && n.length() <20) {content.append("\t");}
		content
			.append(info.get("price"))
			.append(endLine)
			.append(emptyLine)
			.append(ticketMessage)
			.append(emptyLine)
			.append(startLine).append(codeBar).append(endLine)
			.append(startLine).append(codeBar).append(endLine)
			.append(emptyLine);
	}

	public StringBuilder getContent() {return content;}
}
