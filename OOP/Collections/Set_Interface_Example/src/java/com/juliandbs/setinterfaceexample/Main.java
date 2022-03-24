package com.juliandbs.setinterfaceexample;

import com.juliandbs.setinterfaceexample.Employee;
import com.juliandbs.setinterfaceexample.DoorAccess;
import com.juliandbs.setinterfaceexample.Tools;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.lang.StringBuilder;

/**
*       This class is used as part of an example of the use of the Set interface and its implementations.
*       @author JulianDbs
*/
public class Main {
	public static void main(String[] args) {
		Set<Employee> employeesList = Tools.buildEmployeeList();
		printEmployees("Unordered ", employeesList);
		employeesList = new TreeSet<>(employeesList);
		printEmployees("Ordered ", employeesList);
		LinkedHashSet<DoorAccess> checkInDoorRegistry = Tools.buildDoorAccessRegistry(employeesList, true);
		printCheckRegistry("Unordered Check In Registry", checkInDoorRegistry);
		TreeSet<DoorAccess> orderedCheckInRegistry = new TreeSet<>(checkInDoorRegistry);
		printCheckRegistry("Ordered Check In Registry", orderedCheckInRegistry);
		LinkedHashSet<DoorAccess> checkOutDoorRegistry = Tools.buildDoorAccessRegistry(employeesList, false);
		printCheckRegistry("Unordered Check Out Registry", checkInDoorRegistry);
		TreeSet<DoorAccess> orderedCheckOutRegistry = new TreeSet<>(checkOutDoorRegistry);
		printCheckRegistry("Ordered Check Out Registry ", orderedCheckOutRegistry);
		printEmployeesCheckInOut(employeesList, checkInDoorRegistry, checkOutDoorRegistry);
	}

	/**
	*	This method prints the content of a HashSet of employees.
	*	@param title - a string representing a title.
	*	@param employees - a Set implementation containing instances of the Employee class.
	*/
	private static void printEmployees(String title, Set<Employee> employees) {
		String breakLine = "\n";
		String tab = "\t";
		StringBuilder sb = new StringBuilder("|===============================================================|");
		sb.append(breakLine + "|" + tab + tab);
		sb.append(title);
		sb.append(" Employess List");
		String tabCount = title.length() > 7 ? (tab + tab + tab) : (tab + tab + tab + tab + tab + tab);
		sb.append(tabCount);
		sb.append( "|" + breakLine);
		sb.append("|---------------------------------------------------------------|");
		System.out.println(sb.toString());
		employees.stream().forEach(e -> System.out.println(
			"|First Name : " + e.getFirstName() + tab + "|Last Name : " + e.getLastName() + tab + "|Age : " + e.getAge() +  tab + "|"
		));
		System.out.println("|===============================================================|" + breakLine);
	}

	/**
	*	This method prints the content of a Set implementation.
	*	@param title - a String value whit the title to print.
	*	@param checkDoorRegistry - a Set implementation containing instances of the DoorAccess class.
	*/
	private static void printCheckRegistry(String title, Set<DoorAccess> checkDoorRegistry) {
		System.out.println("|===============================================================|\n" +
				   "|\t\t\t" + title + "\t\t|\n" +
				   "|---------------------------------------------------------------|"
		);
		checkDoorRegistry.stream().forEach(e -> System.out.println("  Door Access -> " + e.getAccessDate().toString() + "  " +
									e.getFormattedAccessTime() + " " +
									e.getEmployeeFirstName() + "\t" +
									e.getEmployeeLastName()));
		System.out.println("|===============================================================|\n");
	}

	/**
	*	This method prints the age, the first and last name of each employee and the check in and out time of each one.
	*	@param employeesList - a Set implementation containing instances of the Employee class.
	*	@param checkInDoorRegitry - a Set implementation containing isntances of the DoorAccess class.
	*	@param checkOutDoorRegistry - a Set implementation containing instances of the DoorAccess class.
	*/
	private static void printEmployeesCheckInOut(
		Set<Employee> employeesList,
		Set<DoorAccess> checkInDoorRegistry,
		Set<DoorAccess> checkOutDoorRegistry
		) {
		System.out.println("|===============================================================|\n" +
				   "|\t\t Employees Check In/Out Registry \t\t|\n" +
				   "|---------------------------------------------------------------|"
		);
		employeesList.stream().forEach( e -> System.out.println(
			"|\tEmployee Check Registry of Date : " +
			(checkInDoorRegistry.stream()
				.filter(dc -> dc.getEmployeeFirstName() == e.getFirstName() && dc.getEmployeeLastName() == e.getLastName())
				.findFirst().get().getAccessDate() ) + "\t\t|\n" +
			"|\tEmployee First Name : " + e.getFirstName() + "\t\t\t\t|\n" +
			"|\tEmployee Last Name : " + e.getLastName() + "\t\t\t\t|\n" +
			"|\tEmployee Age : " + e.getAge() + "\t\t\t\t\t|\n" +
			"|\tEmployee Check In Time : " +
			(checkInDoorRegistry.stream()
				.filter(dc -> dc.getEmployeeFirstName() == e.getFirstName() && dc.getEmployeeLastName() == e.getLastName())
				.findFirst().get().getFormattedAccessTime() ) + "\t\t\t|\n" +
			"|\tEmployee Check Out Time : " +
			(checkOutDoorRegistry.stream()
				.filter(dc -> dc.getEmployeeFirstName() == e.getFirstName() && dc.getEmployeeLastName() == e.getLastName())
				.findFirst().get().getFormattedAccessTime() ) +
			"\t\t\t|\n|===============================================================|"
		));
	}

}
