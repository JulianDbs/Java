package com.burger.ingredients;

public class BurgerBun extends Ingredient{
  public BurgerBun() {
    super(10, 10);
    Description = "A type of plain bread formed into rounded bun shape and most often split and used for a hamburger sandwich.";
    Description = Description.concat("\nIt is most often made from a dough prepared from white bread flour, all-purpose flour, or whole-wheat flour.");
    Description = Description.concat("\nCommercially prepared burger buns are often already split and some are occasionally topped with sesame seeds.");
  }
}
