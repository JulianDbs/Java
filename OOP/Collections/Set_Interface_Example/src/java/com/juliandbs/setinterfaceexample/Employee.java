package com.juliandbs.setinterfaceexample;

import java.lang.Comparable;
import java.lang.NullPointerException;

/**
*	This class is used as part of an example of the use of the Set interface and its implementations.
*	@author JulianDbs
*/
public class Employee implements Comparable<Employee> {
	/**
	*	The first name of the employee.
	*/
	private final String firstName;
	/**
	*	The last name of the employee.
	*/
	private final String lastName;
	/**
	*	The age of the employee.
	*/
	private final Integer age;

	/**
	*	Class constructor of the Employee class.
	*	@param firstName - the first name of the employee.
	*	@param lastName - the last name of the employee.
	*	@param age - the age of the employee.
	*	@throws NullPointerException if any of the parameters of this constructor is null
	*/
	public Employee(String firstName, String lastName, Integer age) {
		if (firstName == null || lastName == null || age == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	/**
	*	This method return a String with the first name of the employee.
	*	@return the fist name of the employee.
	*/
	public String getFirstName() {return firstName;}

	/**
	*	This method return a String with the last name of the employee.
	*	@return the last name of the employee.
	*/
	public String getLastName() {return lastName;}

	/**
	*	This method return a Integer with the age of the employee.
	*	@return the age of the employee.
	*/
	public Integer getAge() {return age;}

	/**
	*	Compares two Employee objects by the first name parameter.
	*	@param employee - the Employee object to compared.
	*	@return the value 0 if the fist name parameter of the Employee argument is equal to this Employee first name paramter;
	*		a value less than 0 if this Employee first name parameter is lexicographically less than the fist name parameter of the Employee argument;
	*		and a greater value than 0 if this Employee first name parameter is lexocographically greater than the first name parameter of the Employee argument.
	*/
	@Override
	public int compareTo(Employee employee) {
		int firstNameComparation = firstName.compareTo(employee.getFirstName());
		return (firstNameComparation != 0 ? firstNameComparation : firstName.compareTo(employee.getFirstName()));
	}

	/**
	*	Compares this Employee to the specified object. The result is true if and only if the argument is nor null and is a Employee object that represents a object Employee with the same parameters.
	*	@param object - objecto to compare.
	*	@return true if the given object represent a Employee equivalent to this Employee, false otherwise.
	*/
	@Override
	public boolean equals(Object object) {
		if ( !(object instanceof Employee) )
			return false;
		Employee e = (Employee) object;
		return e.getFirstName().equals(this.firstName) &&
			e.getLastName().equals(this.lastName) &&
			e.getAge().equals(this.age);
	}

	/**
	*	Return a hash code for this object.
	*	@return a hash code for this object.
	*/
	@Override
	public int hashCode() {
		return 31* this.firstName.hashCode() + this.lastName.hashCode() + this.age.hashCode();
	}

	/**
	*	Return a String object representing the parameter values of this object.
	*	@return a string representation of the parameter values of this object.
	*/
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.age;
	}
}
