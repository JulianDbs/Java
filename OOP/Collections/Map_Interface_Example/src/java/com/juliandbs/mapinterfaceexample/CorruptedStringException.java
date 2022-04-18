package com.juliandbs.mapinterfaceexample;

import java.lang.Exception;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public class CorruptedStringException extends Exception {
	private static final long serialVersionUID = 000000001;

	/**
	*	Class constructor of the CorruptedStringException class.
	*/
	public CorruptedStringException() {
		super("This String cannot be converted into a map, please use the valid map and convert it into a String.");
	}
}
