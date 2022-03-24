package com.juliandbs.setinterfaceexample;

import java.lang.Comparable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.lang.NullPointerException;

/**
*	This class is used as part of an example of the use of the Set interface and its implementations.
*	@author JulianDbs
*/
public class DoorAccess implements Comparable<DoorAccess>{
	/**
	*	The date the door was used.
	*/
	private final LocalDate accessDate;
	/**
	*	The time the door was used.
	*/
	private final LocalTime accessTime;
	/**
	*	The first name of the employee who used the door.
	*/
	private final String employeeFirstName;
	/**
	*	The last name of the employee who used the door.
	*/
	private final String employeeLastName;


	/**
	*	Class constructor of the DoorAccess class.
	*	@param accessDate - date the door was used.
	*	@param accessTime - time the door was used.
	*	@param employeeFirstName - first name of the employee who used the door.
	*	@param employeeLastName - last name of the employee who used the door.
	*	@throw NullPointerException if any of the constructor params hava a null value.
	*/
	public DoorAccess(
				LocalDate accessDate,
				LocalTime accessTime,
				String employeeFirstName,
				String employeeLastName
	) throws NullPointerException
	{
		if (accessDate == null || accessTime == null || employeeFirstName == null || employeeLastName == null)
			throw new NullPointerException();
		this.accessDate = accessDate;
		this.accessTime = accessTime;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
	}

	/**
	*	This method return a LocalDate whit the date the door was used.
	*	@return the date the door was used.
	*/
	public LocalDate getAccessDate() {return accessDate;}
	/**
	*	This method return a LocalTime whit the time the door was used.
	*	@return the time the door was used.
	*/
	public LocalTime getAccessTime() {return accessTime;}
	/**
	*	This method return a String whit the time the door was used.
	*	@return the time the door was used.
	*/
	public String getFormattedAccessTime() {
		return accessTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}

	/**
	*	This method return the first name of the employee who used the door.
	*	@return the first name of the employee who used the door.
	*/
	public String getEmployeeFirstName() {return employeeFirstName;}
	/**
	*	This method return the last name of the employee who used the door.
	*	@return the first name of the employee who used the door.
	*/
	public String getEmployeeLastName() {return employeeLastName;}

	/**
	*	Compares two DoorAccess object by the accessTime parameter.
	*	@param doorAccess - another DoorAccess object - the DoorAccess to comapre.
	*	@return the comparator value, negative if less, positive if greater.
	*	@throw NullPointerException if doorAccess is null.
	*/
	@Override
	public int compareTo(DoorAccess doorAccess) throws NullPointerException {
		if (doorAccess == null) {
			throw new NullPointerException();
		}
		int accessTimeComparation = accessTime.compareTo(doorAccess.getAccessTime());
		return (accessTimeComparation != 0 ? accessTimeComparation : accessTime.compareTo(doorAccess.getAccessTime()));
	}

	/**
	*	Check if the "accessDate" and "accessTime" properties of this DoorAccess are equals to the same properties of the object given.
	*	@param obj - the object to check, null returns false.
	*	@return true if this is equals to the other DoorAccess.
	*/
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DoorAccess) )
			return false;
		DoorAccess da = (DoorAccess) obj;
		return da.getAccessDate().equals(this.accessDate) &&
			da.getAccessTime().equals(this.accessTime) &&
			da.getEmployeeFirstName().equals(employeeFirstName) &&
			da.getEmployeeLastName().equals(employeeLastName);
	}

	/**
	*	A hash code for this DoorAccess object.
	*	@return a suitable hash code.
	*/
	@Override
	public int hashCode() {
		return 31* this.accessDate.hashCode() + this.accessTime.hashCode() +
				this.employeeFirstName.hashCode() + this.employeeLastName.hashCode();
	}

	/**
	*	Output this object as String.
	*	@return a String representation of this object, not null.
	*/
	@Override
	public String toString() {
		return this.accessDate.toString() + " " + this.accessTime.toString() + " " +
			this.employeeFirstName + " " + this.employeeLastName;
	}
}
