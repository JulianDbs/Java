# Set Interface Example
> A Java 8 Example.
## Table of Contents
- General Info
- Technologies
- Setup

## General Info

**This is an example of the use of Set Interface and its instances(HashSet, TreeSet and LinkedHashSet) based on the "Collections/interface" section of the [Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)**.

First this program generate a set of 20 employees(using  randoms ages, first and last names) called "employeesList", 
the elements of this set are instances of the "Employee" class.

The "Employee" class have three final private properties, this are :
> - firstName (the first name of the employee)
> - lastName (the last name of the employee)
> - age (the age of the employee)

Next the program generate two sets using the "employeesList" set.

The first one is a set of employees entering to the office building, in a random time between the 9:00 am and the 9:30 am, called "checkInDoorRegistry".

The second is a list of the sames emplyees exiting of the building between the 17:00 pm and the 17:20 pm, called "checkOutDoorRegistry".

The elements of this last two set are instances of the "DoorAccess" class.

The "DoorAccess" class have four final private properties, this are  :
> - accessDate (the date the door was used by the employee).
> - accessTime (the time the door was used bi the employee).
> - employeeFirstName (the first name of the employee).
> - employeeLastName (the last name of the employee).

Whit the three sets builded, the program start to print the element data of each set.

First the program print the elements of the "employeesList" set in the order in this was created, 
then create a new set whit the elements of the original "employeesList" set whit its elements ordered by they first name in alphanumeric order, 
and print its elements.

Next the program print the elements of the "checkInDoorRegistry" set in the order in this was created, 
the create a new set whit the elements of the original "checkInDoorRegistry" set whit its elements ordered by the access time of each employees, 
and print its elements.

The program do the same whit the "checkOutDoorRregistry" set.

In the end the program, using the three sets, print the info of each employee(first name, last name and age) 
and their time of enter and exit from the office building.

## Technologies
Example is created with :
- Java - version 8

## Setup
```
	$ git clone https://github.com/JulianDbs/Java.git
	$ cd Java/OOP/Collections/Set_Interface_Example/
	$ java -cp classes/. com.juliandbs.setinterfaceexample.Main
```