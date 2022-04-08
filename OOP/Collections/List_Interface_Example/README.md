# List Interface Example
> A Java 8 Example using a videogame inventory.
## Table of Contents
- General Info
- Technologies
- Setup

## General Info

**This is an example of the use of List Interface and its instances(ArrayList and LinkedList) based on the "Collections/interface" section of the [Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)**.

First the Main class create an instance of the Inventory class, then add multiple instances of the Item class to it (some of them are stackable items, others are not) and calls the Inventory method 'stackItems'.

The Item class have 7 properties :
> - name (the item name)
> - description (the item description)
> - itemType (the item type)
> - stackable (is this item stackable)
> - amount (the amount of items)
> - maxQuantity (the max item amount)
> - inventoryId (the id of the inventory in which this item is)

and implements the Items Interface which has this methods :
> - getName
> - getDescription
> - getItemType
> - isStackable
> - getAmount
> - setAmount
> - stackIsFull
> - addToStack
> - getInventoryId
> - setInventoryId

The Inventory class have two properties :
> - inventoryId (the inventory id)
> - itemList (a LinkedList of Item instances)

and implements the Inventories Interface which has this methods :
> - addItem (add a new Item instance to the item list)
> - removeItem (remove a Item instance from the item list)
> - findItemByName (find a item by name)
> - getInventoryId (return the inventory id)
> - stackItems (stack all the stackable items)
> - showInventory (print the inventory content)

The 'stackItems' method follows the following process :

1. Create a list of stackable items that appear more than one in the inventory list.

2. Sort the list using the static method 'sort' of the class Collections.

3. Create a ListIterator and instance it using the return ListIterator of the 'listIterator' method of the item list witch is an instance of LinkedList.

4. Create a ArrayList instance called 'toDelete'.

5. Using a while loop, the iterator takes one Item and the next one and compares them. If they are equal, add the quantity of the second to the first using the 'addToStack' method of the Item class and check if the second Item has a quantity equals to 0, if it is the case add that Item to the 'toDelete' list. If not, the second Item becomes the first int the next iteration.

6. Find the Items in the 'toDelete' list in the item list and delete them.


Before and after calling the Inventory method 'stackItems', the Inventory content are displayed to see the changes.

## Technologies
Example is created with :
- Java - version 8

## Setup
```
	$ git clone https://github.com/JulianDbs/Java.git
	$ cd Java/OOP/Collections/List_Interface_Example/
	$ java -cp classes/. com.juliandbs.setinterfaceexample.Main
```