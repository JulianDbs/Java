package com.juliandbs.mapinterfaceexample;

import com.juliandbs.mapinterfaceexample.RegistrationService;
import java.util.LinkedHashMap;
import java.util.Set;

/**
*       This class is used as part of an example of the use of the Map interface and its implementations.
*       @author JulianDbs
*/
public class Main {
	public static void main(String[] args) {
		RegistrationService registrationService = new RegistrationService();
		LinkedHashMap<String, String> LV = new LinkedHashMap<>(User.validMap);
		LinkedHashMap<String, String> NY = new LinkedHashMap<>(User.validMap);
		LinkedHashMap<String, String> M = new LinkedHashMap<>(User.validMap);
		try {
			LV.replace("firstName", "Gil");
			LV.replace("lastName", "Grissom");
			LV.replace("city", "Las Vegas");
			NY.replace("firstName", "Mac");
			NY.replace("lastName", "Taylor");
			NY.replace("city", "New York");
			M.replace("firstName", "Horatio");
			M.replace("lastName", "Caine");
			M.replace("city", "Miami");
		} catch (
			java.lang.UnsupportedOperationException |
			java.lang.ClassCastException |
			java.lang.NullPointerException |
			java.lang.IllegalArgumentException e
		) {
			e.printStackTrace();
		}

		try {
			registrationService.addNewUser(LV.toString());
			registrationService.addNewUser(NY.toString());
			registrationService.addNewUser(M.toString());
		} catch (java.lang.NullPointerException e) {
			System.out.println("The new user map is null");
		} catch (com.juliandbs.mapinterfaceexample.CorruptedStringException cse) {
			System.out.println("The String object that represents the new user map is corrputed.");
		} catch (com.juliandbs.mapinterfaceexample.MissingKeysOnMapException mkome) {
			System.out.println("The new user map has missing keys.");
		} catch (com.juliandbs.mapinterfaceexample.MapContainsNullValuesException mcnve) {
			System.out.println("The new user map contains null values.");
		} catch (com.juliandbs.mapinterfaceexample.UserAlreadyExistsException uaee) {
			System.out.println("The user you are trying to registry already exists in the registration service");
		}

		Set<User> users = registrationService.getUserList();
		System.out.println("Users (" + users.size() + ") :");
		users.stream().forEach(u -> System.out.println("first name : " + u.getFirstName() + " \t-\t last name : " + u.getLastName() + " \t-\t city : " + u.getCity()));
	}

}
