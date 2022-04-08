package com.juliandbs.listinterfaceexample;

import com.juliandbs.listinterfaceexample.Item;
import com.juliandbs.listinterfaceexample.ItemType;
import java.util.Optional;

/**
*       This interface is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public interface Items {
	public String getName();
	public String getDescription();
	public ItemType getItemType();
	public Boolean isStackable();
	public Integer getAmount();
	public void setAmount(Integer amount);
	public Boolean stackIsFull();
	public Optional<Item> addToStack(Item item);
	public Long getInventoryId();
	public void setInventoryId(Long inventoryId);
}
