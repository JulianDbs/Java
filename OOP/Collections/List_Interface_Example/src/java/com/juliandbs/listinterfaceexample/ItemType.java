package com.juliandbs.listinterfaceexample;

/**
*       This enum is used as part of an example of the use of the List interface and its implementations.
*       @author JulianDbs
*/
public enum ItemType {
	Weapon(false, "Weapon"),
	Armor(false, "Armor"),
	Cloth(false, "Cloth"),
	Food(true, "Food"),
	Material(true, "Material"),
	Potion(true, "Potion"),
	QuestItem(false, "Quest Item"),
	Mount(false, "Mount"),
	Ammunition(true, "Ammunition");

	public final boolean stackable;
	public final String type;

	private ItemType(boolean stackable, String type) {
		this.stackable = stackable;
		this.type = type;
	}

	public boolean isStackable() {return stackable;}

	public String getType() {return this.type;}
}
