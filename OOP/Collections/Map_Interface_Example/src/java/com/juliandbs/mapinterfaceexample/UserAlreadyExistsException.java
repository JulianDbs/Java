package com.juliandbs.mapinterfaceexample;

import java.lang.Exception;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 000000001;

	/**
	*	Class constructor of the UserAlreadyExistsException class.
	*/
	public UserAlreadyExistsException() {
		super("The user already exists.");
	}
}
