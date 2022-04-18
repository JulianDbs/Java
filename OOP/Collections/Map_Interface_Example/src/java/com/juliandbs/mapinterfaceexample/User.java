package com.juliandbs.mapinterfaceexample;

import com.juliandbs.mapinterfaceexample.Users;
import com.juliandbs.mapinterfaceexample.MissingKeysOnMapException;
import java.lang.Comparable;
import java.lang.NullPointerException;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Collections;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public class User implements Users, Comparable<User> {
	/**
        *       This is a public static final Immutable Map wich represents a valid map to be used when you want to create a new user via the 'addNewUser' method of this cl>
        */
        public static final Map<String, String> validMap = buildValidMap();

	/**
	*	This method returns a Immutable Map.
	*	@return a Immutable Map.
	*/
	private static Map<String, String> buildValidMap() {
		Map<String, String> hashMap = new LinkedHashMap<>();
		hashMap.put("firstName", "John");
		hashMap.put("lastName", "Smith");
		hashMap.put("city", "Robotnia");
		return  Collections.unmodifiableMap(hashMap);
	};

	private final String firstName;
	private final String lastName;
	private final String city;

	/**
	*	Class constructor of the User class.
	*	@param newUser - a TreeMap that contains the user first name, last name and city.
	*	@thorws NullPointerException if the 'newUser' parameter is null.
	*	@throws MissingKeysOnMapException if the 'newUser' TreeMap parameter has one or more missing keys.
	*/
	public User(TreeMap<String, String> newUser) throws NullPointerException, MissingKeysOnMapException {
		if (newUser == null)
			throw new NullPointerException();
		if (!newUser.keySet().equals(validMap.keySet()))
			throw new MissingKeysOnMapException();
		firstName = newUser.get("firstName");
		lastName = newUser.get("lastName");
		city = newUser.get("city");

	}

	/**
	*	This method returns a String that represents the user first name.
	*	@return a String that represents the first name of the user.
	*/
	@Override
	public String getFirstName() {return firstName;}

	/**
	*	This method returns a String that represents the user last name.
	*	@return a String that represents the last name of the user.
	*/
	@Override
	public String getLastName() {return lastName;}

	/**
	*	This method returns a String that represents the user city.
	*	@return a String that represnts the city of the user.
	*/
	@Override
	public String getCity() {return city;}

	/**
	*	This method return a TreeMap<String, String> with the content of fistName, lastName and city properties, using the name of each one as keys.
	*	@return a new instance of the TreeMap class.
	*/
	@Override
	public TreeMap<String, String> toMap() {
		TreeMap<String, String> result = new TreeMap<>();
		result.put("firstName", firstName);
		result.put("lastName", lastName);
		result.put("city", city);
		return result;
	}

	/**
	*	This method compares two User objects.
	*	@param user - the User object to be compared.
	*	@return the value 0 if the properties of the 'user' parameter are equals to this User properties;
	*		a value less than 0 if this User properties are lexicographically less than the properties of the 'user' parameter;
	*		and a greater value than 0 if this User properties are lexicographically greater than the properties of the 'user' parameter.
	*	@throws NullPointerException if the 'user' parameter is null.
	*/
	@Override
	public int compareTo(User user) {
		if (user == null)
			throw new NullPointerException();
		return user.getFirstName().compareTo(firstName) +
			user.getLastName().compareTo(lastName) +
			user.getCity().compareTo(city);
	}

	/**
	*	This method compares this User to the specified object.
	*	@param object - the object to compare.
	*	@return true if and only if the 'object' property is not null and is a User object that represents a User object with the same parameters, otherwise false.
	*/
	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if (object instanceof User) {
			User user = (User) object;
			result = user.getFirstName().equals(firstName) &&
				user.getLastName().equals(lastName) &&
				user.getCity().equals(city);
		}
		return result;
	}

	/**
	*	This method returns a hash code for this object.
	*	@return a hash code for this object.
	*/
	@Override
	public int hashCode() {
		return 31 * firstName.hashCode() +
				lastName.hashCode() +
				city.hashCode();
	}

	/**
	*	This method return a String that represents the properties values of this object.
	*	@return a String representation of the properties of this object.
	*/
	@Override
	public String toString() {
		return firstName + " " + lastName + " " + city;
	}
}
