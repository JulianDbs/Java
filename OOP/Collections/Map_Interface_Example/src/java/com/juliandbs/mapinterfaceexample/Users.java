package com.juliandbs.mapinterfaceexample;

import java.util.TreeMap;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public interface Users {
	public String getFirstName();
	public String getLastName();
	public String getCity();
	public TreeMap<String, String> toMap();
}
