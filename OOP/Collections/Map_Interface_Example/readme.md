# Map Interface Example
> A Java 8 Example using a registration pseudo-service.
## Table of Contents
- General Info
- Technologies
- Setup

## General Info

**This is an example of the use of Map Interface and its instances(HashMap, TreeMap and LinkedHashMap) based on the "Collections/interface" section of the [Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)**.

- Fist the 'Main' class creates a new instance of the 'RegistrationService' class and three new instances of the LinkedHashMap class using the static immutable map 'validMap' from the 'User' class.
- Next the 'Main' class replaces the three keys of each LinkedHashMap instance with new data.
- At the end, using each LinkedHashMap, try to create new users in the 'RegistrationService' class using the 'addNewUser' method of that class and display the list of users.

The 'addNewUser' method receives a String object as an argument, it comes from the 'toString' method called on each LinkedHashMap instance in the 'Main' class.
The method then converts the string to a 'HashMap', checks if it has all the necessary keys and if it contains null values. If it's a valid map, it convert it to a 'TreeMap, uses it to create a new instance of the 'User' class and adds it to the users list, if not, it throws an exception.

## Technologies
Example is created with :
- Java - version 8

## Setup
```
	$ git clone https://github.com/JulianDbs/Java.git
	$ cd Java/OOP/Collections/Map_Interface_Example/
	$ java -cp classes/. com.juliandbs.mapinterfaceexample.Main
```