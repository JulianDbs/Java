package com.burger.ingredients;

public abstract class Ingredient {
  public static int Flavor;
  public static int Nutrition;
  public static String Description;

  public Ingredient() {
    Flavor = 0;
    Nutrition = 0;
  }

  public Ingredient(int Flavor, int Nutrition) {
    this.Flavor = Flavor;
    this.Nutrition = Nutrition;
  }

}
