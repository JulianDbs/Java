package com.juliandbs.listinterfaceexample;

import com.juliandbs.listinterfaceexample.ItemType;
import com.juliandbs.listinterfaceexample.Item;
import com.juliandbs.listinterfaceexample.ItemNotFoundException;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;

/**
*       This interface is used as part of an example of the use of the List interface and its implementations.
*       @author JulianDbs
*/
public interface Inventories {
	public void addItem(Item item) throws NullPointerException;
	public void removeItem(Item item, Integer index) throws ItemNotFoundException, IndexOutOfBoundsException, NullPointerException;
	public LinkedList<Item> findItemByName(String name);
	public Long getInventoryId();
	public void stackItems();
	public void showInventory();
}
