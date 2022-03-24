package com.juliandbs.setinterfaceexample;

import com.juliandbs.setinterfaceexample.Employee;
import com.juliandbs.setinterfaceexample.DoorAccess;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalTime;

/**
*	This class is used as part of an example of the use of the Set interface and its implementations.
*	@author JulianDbs
*/
public class Tools {
	private static Random rand = new Random();

	/**
	*	This is a static HashSet with 19 String representing a list of common male fist names.
	*/
	private final static List<String> maleFirstNames = new ArrayList<String>(
		Arrays.asList(
			"Jhon", "Bob", "Tomas", "Boris", "Carl", "Victor", "Ivan",
			"Walter", "Denis", "Sergey", "Robert", "Donald", "Gary",
			"Ilya", "Andrey", "Brian", "Jacob", "Paul", "Charles"
		)
	);

	/**
	*	This is a static HashSet with 19 String representing a list of common female fist names.
	*/
	private final static List<String> femaleFirstNames = new ArrayList<String>(
		Arrays.asList(
			"Irina", "Tatiana", "Olivia", "Elizabeth", "Vera", "Nadezhda", "Svetlana",
			"Victoria", "Chloe", "Stella", "Natalie", "Daria", "Anna",
			"Madelyn", "Sophie", "Samantha", "Lydia", "Vivian", "Julia"
		)
	);

	/**
	*	This is a static HashSet with 46 String representing a list of common last names.
	*/
	private final static List<String> lastNameList = new ArrayList<String>(
		Arrays.asList(
			"Ivanov", "Smith", "Williams", "Smith", "Vasiliev", "Kozlov",
			"Brown", "Jones", "Garcia", "Lopez", "Rodriguez", "Wilson",
			"Anderson", "Orlov", "Agapov", "Balabanov", "Agafonov",
			"Gonzales", "Taylor", "Moore", "Jackson", "Martin", "Lee",
			"Balakin", "Baranov", "Artyomov", "Gurin", "Levitsky", "Lopatin",
			"Perez", "Thompson", "White", "Harris", "Sanchez", "Clark",
			"Lewis", "Robinson", "Walker", "Young", "Allen", "Scott",
			"Arsenyev", "Yahontov", "Babanin", "Kuznetsov", "Smirnoff"
		)
	);

	/**
	*	This method build a HashSet with 20 instances of the Employee class.
	*	@return HashSet<Employee> a list of 20 random employees.
	*/
	public static HashSet<Employee> buildEmployeeList() {
		HashSet<Employee> list = new HashSet<>();
		boolean gender = true;
		for (int i = 0; i < 20; i++) {
			list.add(new Employee(
				getRandomFirstName(gender, rand),
				getRandomLastName(rand),
				getRandomAge(rand)
			));
			gender = !gender;
		}
		return list;
	}

	/**
	*	This method return a random first name from a list of first names.
	*	@param male - a boolean parameter true to set if the name is a male name or false to female.
	*	@param ranfom - a instance of the Random class.
	*	@return a string which contains a random male or female first name.
	*/
	private static String getRandomFirstName(boolean male, Random random) {
		int n = random.nextInt(19);
		return (male == true) ? maleFirstNames.get(n) : femaleFirstNames.get(n);
	}

	/**
	*	This method return a random last name from a list of last names.
	*	@param random - a instance of the Random class.
	*	@return a string which contains a random last name.
	*/
	private static String getRandomLastName(Random random) {
		return lastNameList.get(random.nextInt(46));
	}

	/**
	*	This method return a random integer between 21 and 51.
	*	@param random - a instance of the Random class.
	*	@return a Integer which contains a random age between 21 and 51.
	*/
	private static Integer getRandomAge(Random random) {
		return (21 + random.nextInt(30));
	}

	/**
	*	This method build and return a new LinkedHashSet containing 20 instances of the DoorAccess class.
	*	@param emplyees - a Set of instances of the Employee class.
	*	@param morningBusinessHours - a boolean value that indicate whether the access is in the morning or in the afternoon.
	*	@return a new LinkedHashSet containing 20 instances of the DoorAccess class.
	*/
	public static LinkedHashSet<DoorAccess> buildDoorAccessRegistry(Set<Employee> employees, boolean morningBusinessHours) {
		LinkedHashSet<DoorAccess> result = employees.stream()
		.map(e -> new DoorAccess(	LocalDate.now(),
						(morningBusinessHours == true) ? getBusinessHours(rand, 9, 30, 59) : getBusinessHours(rand, 17, 20, 59),
						e.getFirstName(),
						e.getLastName() ) )
		.collect(Collectors.toCollection(LinkedHashSet::new));
		return result;
	}

	/**
	*	This method return a new LocalTime object that represents a morning time with random minutes and seconds.
	*	@param random - a random instance of the Random class.
	*	@param hour - integer value representing a hour of the day.
	*	@param minute - integer value representing a minute of the day.
	*	@param second - integer value representing a second of the day.
	*	@return a new LocalTime instance.
	*/
	private static LocalTime getBusinessHours(
			Random random,
			Integer hour,
			Integer minute,
			Integer second
		) {
		LocalTime result = LocalTime.now();
		result = result.withHour(hour);
		result = result.withMinute(random.nextInt(minute));
		result = result.withSecond(random.nextInt(second));
		return result;
	}
}
