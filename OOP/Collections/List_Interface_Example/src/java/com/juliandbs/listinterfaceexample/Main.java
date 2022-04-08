package com.juliandbs.listinterfaceexample;

import com.juliandbs.listinterfaceexample.Item;
import com.juliandbs.listinterfaceexample.ItemType;
import com.juliandbs.listinterfaceexample.Inventory;

public class Main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory(Long.valueOf(123456));
		addItems(inventory);
		inventory.showInventory();
		inventory.stackItems();
		inventory.showInventory();
	}

	public static void addItems(Inventory inventory) {
		try {
			inventory.addItem(new Item("Wooden Bow", "A wooden bow.", ItemType.Weapon));
			inventory.addItem(new Item("Wooden Bow", "A wooden bow.", ItemType.Weapon));
			inventory.addItem(new Item("Wooden Arrow", "A wooden arrow", ItemType.Ammunition, 9980));
			inventory.addItem(new Item("Stone Arrow", "A stone arrow", ItemType.Ammunition, 10));
			inventory.addItem(new Item("Wooden Arrow", "A wooden arrow", ItemType.Ammunition, 9999));
			inventory.addItem(new Item("Wooden Arrow", "A wooden arrow", ItemType.Ammunition, 5));
			inventory.addItem(new Item("Wooden Arrow", "A wooden arrow", ItemType.Ammunition, 50));
			inventory.addItem(new Item("Stone Arrow", "A stone arrow", ItemType.Ammunition, 2));
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
		}
	}
}
