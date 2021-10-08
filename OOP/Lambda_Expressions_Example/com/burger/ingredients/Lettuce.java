package com.burger.ingredients;

public class Lettuce extends Ingredient {
  public Lettuce() {
    super(-100, 30);
    Description = "Lettuce(Lactua sativa) is an annual plant of the daisy family,";
    Description = Description.concat("\nis most often used for salads, soups and sandwiches.");
    Description = Description.concat("\nA single piece of Lettuce can ruin your burger and your marriage at the same time.");
  }
}
