package com.VendingMachine;

import java.util.Scanner;
import com.VendingMachine.products.*;
import com.VendingMachine.Tools;
import com.VendingMachine.VendingMachine;
import com.VendingMachine.Purchase;

public interface UserConsole{
	public final Scanner scanner = new Scanner(System.in);

	public default void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		scanner .reset();
	}

	public default void US_start() {
		clearScreen();
		System.out.format("Welcome to Vending Machine VM-800%n%nPlease Select the type Product and press Enter :%n%n");
		System.out.format("1 : Drink%n2 : Food%n3 : Candy%n%n0 : exit%n%nOption : ");
		String line = scanner.nextLine();
		switch(line) {
			case "0" : break;
			case "1" : US_drinks(); break;
			case "2" : US_food(); break;
			case "3" : US_candy(); break;
			default :  US_start(); break;
		}
	}

	public default void US_drinks() {
		clearScreen();
		System.out.format("Welcome to Vending Machine VM-800%n%nPlease choose one of these dinks and press Enter :%n%n");
		System.out.format("1 : YodaSoda %n2 : Coffe%n3 : Tea%n4 : Bottle of Water%n9 : previous menu%n%n0 : exit%n%nOption : ");
		String line = scanner.nextLine();
		switch(line) {
			case "0" : break;
			case "1" : US_purchaseConfirmation(new Purchase<YodaSoda>(new YodaSoda())); break;
			case "2" : US_purchaseConfirmation(new Purchase<Coffe>(new Coffe())); break;
			case "3" : US_purchaseConfirmation(new Purchase<Tea>(new Tea())); break;
			case "4" : US_purchaseConfirmation(new Purchase<Water>(new Water())); break;
			case "9" : US_start(); break;
			default : US_drinks(); break;
		}
	}

	public default  void US_food() {
		clearScreen();
		System.out.format("Welcome to Vending Machine VM-800%n%nPlease choose on of these unhealty food options and press Enter : %n%n");
		System.out.format("1 : Cheese Sandwich 'LastHour'%n2 : Ham Sandwitch 'Lecter'%n%n9 : previous menu%n%n0 : exit%n%nOption : ");
		String line = scanner.nextLine();
		switch(line){
			case "0" : break;
			case "1" : US_purchaseConfirmation(new Purchase<CheeseSandwitch>(new CheeseSandwitch())); break;
			case "2" : US_purchaseConfirmation(new Purchase<HamSandwitch>(new HamSandwitch())); break;
			case "9" : US_start(); break;
			default : US_food(); break;
		}
	}

	public default void US_candy() {
		clearScreen();
		System.out.format("Welcome to Vending Machine VM-800%n%nPlease choose one of these high sugar tooth killers and press Enter : %n%n");
		System.out.format("1 : Chocolate Bar 'WonkaKiller'%n2 : CookiesCat 'Manja'%n%n9 : previous menu%n%n0 : exit%n%nOption : ");
		String line = scanner.nextLine();
		switch(line) {
			case "0" : break;
			case "1" : US_purchaseConfirmation(new Purchase<ChocolateBar>(new ChocolateBar())); break;
			case "2" : US_purchaseConfirmation(new Purchase<CookiesCat>(new CookiesCat())); break;
			case "9" : US_start(); break;
			default : US_candy(); break;
		}
	}

	public default void US_purchaseConfirmation(Purchase<? extends Product> p) {
		clearScreen();
		System.out.format("Please Confirm Your Purchase : %n%n1 : Confirm%n0 : Cancel Operation%n%nOption : ");
		String line = scanner.nextLine();
		switch(line) {
			case "0": US_start(); break;
			case "1": US_processPurchase(p); break;
			default : US_purchaseConfirmation(p); break;
		}
	}

	public abstract void US_processPurchase(Purchase<? extends Product> p);
}
