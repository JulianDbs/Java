package com.juliandbs.mapinterfaceexample;

import java.lang.Exception;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public class MissingKeysOnMapException extends Exception {
	private static final long serialVersionUID = 000000001;

	/**
	*	Class Constructor of the MissingKeysOnMapException class.
	*/
	public MissingKeysOnMapException() {
		super("One or more keys are missing from the map.");
	}

}
