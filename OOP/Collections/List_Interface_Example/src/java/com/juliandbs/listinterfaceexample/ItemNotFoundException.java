package com.juliandbs.listinterfaceexample;

import java.lang.Exception;

public class ItemNotFoundException extends Exception {
	static final long serialVersionUID = 000000001;

	public ItemNotFoundException() {
		super("Item Not Found");
	}
}
