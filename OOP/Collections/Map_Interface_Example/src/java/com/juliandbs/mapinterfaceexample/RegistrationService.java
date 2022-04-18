package com.juliandbs.mapinterfaceexample;

import com.juliandbs.mapinterfaceexample.RegistrationServiceInterface;
import com.juliandbs.mapinterfaceexample.MissingKeysOnMapException;
import com.juliandbs.mapinterfaceexample.CorruptedStringException;
import com.juliandbs.mapinterfaceexample.MapContainsNullValuesException;
import com.juliandbs.mapinterfaceexample.UserAlreadyExistsException;
import java.lang.NullPointerException;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
*       This class is used as part of an example of the use of the Map interface and its implementations.
*       @author JulianDbs
*/
public class RegistrationService implements RegistrationServiceInterface {
	private HashSet<User> userList = new HashSet<>();

	/**
	*	Class constructor of the RegistrationService class.
	*/
	public RegistrationService() {}


	/**
	*	This method add a new User into de user list.
	*	@param string - a String that represents a Map turned into a String.
	*	@throws NullPointerException if the serializedMap parameter is null.
	*/
	@Override
	public void addNewUser(String string)
		throws NullPointerException,
			CorruptedStringException,
			MissingKeysOnMapException,
			MapContainsNullValuesException,
			UserAlreadyExistsException {
		if (string == null)
			throw new NullPointerException();
		if (!isValidString(string))
			throw new CorruptedStringException();
		HashMap<String, String> newMap = stringToMap(string);
		if (!isValidMap(newMap)){
			throw new MissingKeysOnMapException(); }
		if (containsNullValues(newMap))
			throw new MapContainsNullValuesException();
		TreeMap<String, String> treeMap = new TreeMap<>(newMap);
		User newUser = new User(treeMap);
		userList.add(newUser);
	}

	@Override
	public Set<User> getUserList() {return userList;}

	/**
	*	This method checks if the String object given as argument contains the ',' and '='.
	*	@param string - a String that represents a Map turned into a String.
	*	@return true if the String contains ',' and '=', otherwise false.
	*/
	private boolean isValidString(String string) {
		return string.contains(",") && string.contains("=");
	}

	/**
	*	This method convert the String given as argument into a Map instance.
	*	@param serializedMap - a String that represents a serialized Map.
	*	@return a new HashMap instance.
	*/
	private HashMap<String, String> stringToMap(String stringMap) {
		Map<String, String> result = Arrays.stream(stringMap.split(","))
							.map(e -> e.split("="))
							.collect(Collectors.toMap(e -> clearString(e[0]), e -> clearString(e[1]) ));
		return new HashMap<String, String>(result);
	}

	/**
	*	This method return a String object that represents the String argument 'target' without the characters '{' and '}';
	*	If the 'target' paramter starts with ' ', the spaces is removed to.
	*	@param target - The String object to process.
	*	@return a String object that represent the 'target' parameter without the characters described above.
	*/
	private String clearString(String target) {
		String d = (target.startsWith(" ")) ? target.substring(1) : target;
		char[] parts = d.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		Character a = Character.valueOf( (char)123), b = Character.valueOf( (char)125);
		for (Character c : parts) {
			if (!c.equals(a) && !c.equals(b)) {stringBuilder.append(c.toString());}
		}
		return stringBuilder.toString();
	}

	/**
	*	This method checks if the TreeMap object contains the keys needed to create a new instance of the User class.
	*	@param newUser - a TreeMap instance.
	*	@return true if the TreeMap contains the same keys of the validMap example, otherwise false.
	*/
	private boolean isValidMap(HashMap<String, String> newUser) {
		return newUser.keySet().containsAll(User.validMap.keySet());
	}

	/**
	*	This method checks if the HashMap object given as argument contains null values.
	*	@param newUser - a HashMap object.
	*	@return true if any of the keys of this TreeMap contains a null value, otherwise false.
	*/
	private boolean containsNullValues(HashMap<String, String> newUser) {
		return newUser.get("firstName") == null ||
			newUser.get("lastName") == null ||
			newUser.get("city") == null;
	}

	/**
	*	This method checks if the list of users already contains an User like the User given has argument.
	*	@param user - a User that represents the user to seach into the user list.
	*	@return true if the user list contains a user like the user given as argument, otherwise false.
	*/
	private boolean userAlreadyExists(User user) {
		return userList.contains(user);
	}
}
