package com.burger.ingredients;

public class CheddarCheese extends Ingredient {
  
  public CheddarCheese() {
    super(100, 20);
    Description = "Commonly known as cheddar, originates from the village of Cheddar in Somerset.";
    Description = Description.concat("\nIt has been produced in large quantities since mankind discovered fire.");
    Description = Description.concat("\nScientists affirm that 100 grams of this cheese would take between 4 seconds and 4 years to degrade.");
  }
}
