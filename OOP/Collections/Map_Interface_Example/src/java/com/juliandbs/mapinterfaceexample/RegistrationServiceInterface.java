package com.juliandbs.mapinterfaceexample;

import com.juliandbs.mapinterfaceexample.User;
import com.juliandbs.mapinterfaceexample.CorruptedStringException;
import com.juliandbs.mapinterfaceexample.MissingKeysOnMapException;
import com.juliandbs.mapinterfaceexample.MapContainsNullValuesException;
import com.juliandbs.mapinterfaceexample.UserAlreadyExistsException;
import java.lang.NullPointerException;
import java.util.Set;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public interface RegistrationServiceInterface {
	public void addNewUser(String serializedMap) throws NullPointerException, CorruptedStringException, MissingKeysOnMapException, MapContainsNullValuesException, UserAlreadyExistsException;
	public Set<User> getUserList();
}
