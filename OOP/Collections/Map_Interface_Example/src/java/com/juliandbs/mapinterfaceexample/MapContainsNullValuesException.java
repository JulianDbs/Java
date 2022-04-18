package com.juliandbs.mapinterfaceexample;

import java.lang.Exception;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public class MapContainsNullValuesException extends Exception {
	private static final long serialVersionUID = 000000001;

	/**
	*	Class constructor of the MapContainsNullvaluesException class.
	*/
	public MapContainsNullValuesException() {
		super("This map contains null values");
	}
}
