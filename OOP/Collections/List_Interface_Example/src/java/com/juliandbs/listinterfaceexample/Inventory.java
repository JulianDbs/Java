package com.juliandbs.listinterfaceexample;

import com.juliandbs.listinterfaceexample.ItemType;
import com.juliandbs.listinterfaceexample.Item;
import com.juliandbs.listinterfaceexample.ItemNotFoundException;
import com.juliandbs.listinterfaceexample.Inventories;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.lang.NullPointerException;
import java.lang.IndexOutOfBoundsException;
import java.util.Optional;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/

public class Inventory implements Inventories {
	private final Long inventoryId;

	private LinkedList<Item> itemList = new LinkedList<>();

	/**
	*	Class constructor of the Inventory class.
	*	@param inventoryId - an Integer value that represents the inventory id.
	*/
	public Inventory(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	*	This method is used to add a new an Item intance to the List.
	*	@param item - an instance of the Item class.
	*	@throws NullPointerException if the item parameter is null.
	*/
	@Override
	public void addItem(Item item) throws NullPointerException {
		if (item == null) {
			throw new NullPointerException();
		}
		item.setInventoryId(inventoryId);
		itemList.add(item);
	}

	/**
	*	This method is used to remove an Item from from the list of Items inside this class.
	*	@param item - an Item instance representing the Item to delete-
	*	@param index - the index of the Item to delete inside the Item list.
	*	@throws ItemNotFoundException - if the item cannot be found inside the item list.
	*	@throws IndexOutOfBoundsException - if the index is more that the size of the item list.
	*	@throws NullPointerException - if any if the parameters are null.
	*/
	@Override
	public void removeItem(Item item, Integer index) throws ItemNotFoundException, IndexOutOfBoundsException, NullPointerException {
		if (item == null || index == null) {throw new NullPointerException();}
		if (itemList.size() <= (index - 1) ) {
			if (itemList.get(index).equals(item)) {
				itemList.remove(index);
			} else {
				throw new ItemNotFoundException();
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	*	This method return a LinkedList containing the Items whose name matches the String given as a parameter.
	*	@param name - a String value representing the name of the item(s) to search for.
	*	@return a LinkedList that may or many not contain the items whose name matches the given name.
	*	@trows NullPointerException - if the name parameter is null.
	*/
	@Override
	public LinkedList<Item> findItemByName(String name) throws NullPointerException {
		if (name == null) { throw new NullPointerException();}
		LinkedList<Item> result = itemList.stream()
			.filter( (e) -> e.getName().equals(name) )
			.collect(Collectors.toCollection(LinkedList::new));
		return result;
	}

	/**
	*	This method return a Long object containing a long value that represents the id of this inventory.
	*	@return a Long object that represents the id of this inventory.
	*/
	@Override
	public Long getInventoryId() {return inventoryId;}

	/**
	*	This method finds the items in the list that are stackable and have a quantity less than 9999,
	*	then stacks the items that are identical to each others.
	*/
	@Override
	public void stackItems() {
		LinkedList<Item> list = itemList.stream()
						.filter( e -> java.util.Collections.frequency(itemList, e) > 1)
						.filter( (e) -> e.getItemType() == ItemType.Food ||
								e.getItemType() == ItemType.Material ||
								e.getItemType() == ItemType.Potion ||
								e.getItemType() == ItemType.Ammunition
						)
						.filter( e -> !e.stackIsFull() )
						.collect(Collectors.toCollection(LinkedList::new));
		renderInventory("\nStackables Items", list);
		Collections.sort(list);
		java.util.ListIterator<Item> listIterator = list.listIterator(0);
		ArrayList<Item> toDelete = new ArrayList<>();
		while(listIterator.hasNext()) {
			Item firstItem = listIterator.next();
			if (listIterator.hasNext()) {
				Item secondItem = listIterator.next();
				if (firstItem.equals(secondItem)) {
					Optional<Item> result = firstItem.addToStack(secondItem);
					if (result.isPresent()) {
						secondItem = result.get();
					} else {
						toDelete.add(secondItem);
						listIterator.remove();
					}
				}
				listIterator.previous();
			}
		}
		renderInventory("\nItems to delete", new LinkedList<Item>(toDelete));
		for (Item target : toDelete) {
			for (int i = 0; i < itemList.size(); i++ ) {
				if (itemList.get(i).equals(target) && itemList.get(i).getAmount().equals(target.getAmount())) {itemList.remove(i);}
			}
		}
	}

	/**
	*	This method prints the contents of the inventory on the console.
	*/
	@Override
	public void showInventory() {renderInventory("\nInventory", itemList);}

	/**
	*	This method prints a title and the contents of a LinkedList of Item instances on the console.
	*	@param title - a String that represents the title.
	*	@param itemList - a LinkedList of Item instances.
	*/
	private void renderInventory(String title, LinkedList<Item> itemList) {
		String bar = "|===============================================================|";
		StringBuilder stringBuilder = new StringBuilder(title + "\n" + bar);
		stringBuilder.append("\n|\tName\t\t|\tType\t\t|\tAmount\t|\n").append(bar);
		System.out.println(stringBuilder.toString());
		ArrayList<Item> list = new ArrayList<>(itemList);
		list.stream().forEach( (i) -> System.out.println("|\t" + i.getName() + getTabs(i.getName()) + "|\t" +
									 i.getItemType() + getTabs(i.getItemType().getType()) + "|\t" +
									 i.getAmount() + getTabs(i.getAmount().toString()) + "|\n" + bar) );
	};

	/**
	*	This method return a String containing a number of '\t'(tabs) depending on the length of the String given as a paramaeter.
	*	@param sample - the String used to get the length.
	*	@return the String containing the tabs.
	*/
	private String getTabs(String sample) {
		String result = "";
		switch(sample.length()) {
			case 1: case 2: case 3: case 4:
				result = "\t";
				break;
			case 5: case 6: case 7:
				result = "\t\t";
				break;
			default: result = "\t";
		}
		return result;
	}

}
