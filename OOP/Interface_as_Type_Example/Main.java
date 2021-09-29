import java.util.ArrayList;

public class Main {
  public static void main(String[] arags) {
      Strawberry_Ice_Cream Strawberry_IC = new Strawberry_Ice_Cream();
      Ice_Cream Ic = (Ice_Cream)Strawberry_IC;
      Ic.DescribeIngredients();
      Ic.Eat();
  }
}

public interface Ice_Cream {
  public abstract void DescribeIngredients();
  public abstract void Eat();
}

public class Strawberry_Ice_Cream implements Ice_Cream {
    private ArrayList<String> Ingredients;

    public Strawberry_Ice_Cream() {
      Ingredients = new ArrayList<>();
      Ingredients.add("Heavy Cream");
      Ingredients.add("Condensed Milk");
      Ingredients.add("Strawberrys");
      Ingredients.add("Sugar");
    }

    @Override
    public void DescribeIngredients() {
      System.out.println("(Describe Ingredients)");
      System.out.println("Ingredients : ");
      for (String Ingredient:Ingredients) {
        System.out.println("-> " + Ingredient);
      }
    }

    @Override
    public void Eat() {
      System.out.println("(Eat)");
      System.out.println("Subarashii !!!");
    }
}
