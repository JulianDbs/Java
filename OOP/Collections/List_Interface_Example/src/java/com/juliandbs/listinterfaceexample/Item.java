package com.juliandbs.listinterfaceexample;

import com.juliandbs.listinterfaceexample.Items;
import com.juliandbs.listinterfaceexample.ItemType;
import java.lang.NullPointerException;
import java.lang.Comparable;
import java.util.Optional;

/**
*       This class is used as part of an example of the use of the List interface and its implementations.
*       @author JulianDbs
*/
public class Item implements Items, Comparable<Item> {
	private final String name;
	private final String description;
	private final ItemType itemType;
	private final Boolean stackable;
	private int amount;
	private static int maxQuantity = 9999;
	private long inventoryId = -1;

	/**
	*	Class constructor of the Item class.
	*	@param name - a String representing the item name.
	*	@param description - a String representing the item description.
	*	@param itemType - a instance of the ItemType class that represents the item type.
	*	@param amount - a Integer value that indicates the amount of items if this is not a unique item, otherwise it is 1;
	*	@throws NullPointerException - if any of the constructor paramters is null.
	*/
	public Item(
		String name,
		String description,
		ItemType itemType,
		Integer amount
	) throws NullPointerException {
		if (name == null || description == null || itemType == null || amount == null) {
			throw new NullPointerException();
		}
		this.name = name;
		this.description = description;
		this.itemType = itemType;
		this.stackable = itemType.isStackable();
		this.amount = (stackable)? amount : 1;
	}

	/**
	*	Class constructor of the Item class.
	*	@param name - a String representing the item name.
	*	@param description - a String representing the item description.
	*	@param itemType - a instance of the ItemType class that represents the item type.
	*	@throws NullPointerException - if any of the constructor paramters is null.
	*/
	public Item(
		String name,
		String description,
		ItemType itemType
	) throws NullPointerException {
		if (name == null || description == null || itemType == null) {throw new NullPointerException();}
		this.name = name;
		this.description = description;
		this.itemType = itemType;
		this.stackable = itemType.isStackable();
		this.amount = 1;
	}

	/**
	*	This method return a String representing the name of the item.
	*	@return the name of the item.
	*/
	@Override
	public String getName() {return name;}


	/**
	*	This method returns a String reppresenting the description of the item.
	*	@return the description of the item.
	*/
	@Override
	public String getDescription() {return description;}


	/**
	*	This method returns the ItemType of this item.
	*	@return a instance of the ItemType class.
	*/
	@Override
	public ItemType getItemType() {return itemType;}

	/**
	*	This method checks if the item is stackable.
	*	@return True if the item is stackable, False if it is not.
	*/
	@Override
	public Boolean isStackable() {return stackable;}

	/**
	*	This method get the amount of item if this item is not a unique item.
	*	@return if this item is stackable it returns the quantity of items, if this item is unique it return 1.
	*/
	@Override
	public Integer getAmount() {return amount;}

	/**
	*	This method set the item amount of this item.
	*	@param amount - a Integer object containing a value representing the new amount value.
	*/
	@Override
	public void setAmount(Integer amount) {this.amount = amount;}

	/**
	*	This method get the inventory id.
	*	@return returns a Long object containing a value of the inventoryId paramter of this item.
	*/
	@Override
	public Long getInventoryId() {return inventoryId;}

	/**
	*	This method set the inventory id.
	*	@param inventoryId - an Integer value representing the inventory id.
	*/
	public void setInventoryId(Long inventoryId) {this.inventoryId = inventoryId.longValue();}

	/**
	*	This method checks if the maximum amount of items was reached.
	*	@return True if the amount of items is equals to 99999, False if not.
	*/
	@Override
	public Boolean stackIsFull() {return amount == maxQuantity; }

	/**
	*	This method adds x number of items to this item.
	*	finish this please !!!!!!!
	*	@param item - a Item instnace.
	*	@return a Optional instance containing a Item instance.
	*/
	@Override
	public Optional<Item> addToStack(Item item) {
		Optional<Item> result = Optional.empty();
		if (amount < 9999) {
			int allowed = 9999 - amount;
			int itemCount = item.getAmount();
			Integer added = (itemCount >= allowed)? allowed : itemCount;
			Integer leftover = (itemCount <= allowed) ? 0 : itemCount - added;
			amount = amount + added;
			if (leftover > 0) {
				item.setAmount(leftover);
				result = Optional.ofNullable(item);
			}
		}
		return result;
	}

	/**
	*	This method compares two Item objects.
	*	@param item - the Item object to be compared.
	*	@return the value 0 if the parameters of the item argument are equals to this Item parameters;
	*		a value less than 0 if this Item parameters are lexicographically less than the parameters of the Item argument;
	*		and a greater value than 0 if this Item parameters are lexicographically greater than the parameters of Item argument.
	*/
	@Override
	public int compareTo(Item item) {
		return 	item.getName().compareTo(this.name) +
			item.getDescription().compareTo(this.description) +
			item.getItemType().getType().compareTo(this.itemType.getType()) +
			item.isStackable().compareTo(this.stackable) +
			item.getAmount().compareTo(Integer.valueOf(this.amount)) +
			item.getInventoryId().compareTo(Long.valueOf(this.inventoryId));
	}

	/**
	*	This method compares this Item to the specified object.
	*	The result is true if and only if the argument object is not null and is a Item object that represents a Item object with the same parameters.
	*	@param object - object to compare.
	*	@return true if the given object represent a Item equivalent to this Item, false otherwise.
	*/
	@Override
	public boolean equals(Object object) {
		if (object instanceof Item) {
			Item item = (Item) object;
			return item.getName().equals(this.name) &&
				item.getDescription().equals(this.description) &&
				item.getItemType() == this.itemType &&
				item.isStackable() == this.stackable &&
				item.getInventoryId() == this.inventoryId;
		} else {
			return false;
		}
	}

	/**
	*	This method returns a hash code for this object.
	*	@return a hash code for this object.
	*/
	@Override
	public int hashCode() {
		return 31 * this.name.hashCode() +
				this.description.hashCode() +
				this.itemType.getType().hashCode() +
				Integer.valueOf(this.amount).hashCode() +
				Long.valueOf(this.inventoryId).hashCode();
	}

	/**
	*	This method returns a String object representing the parameter values of this object.
	*	@return a String representation of the parameter values of this object.
	*/
	@Override
	public String toString() {
		return this.name.toString() + " " +
			this.description.toString() + " " +
			this.itemType.getType() + " " +
			this.stackable.toString() + " " +
			String.valueOf(this.amount) + " " +
			String.valueOf(this.inventoryId);
	}
}
