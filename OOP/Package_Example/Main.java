import java.util.ArrayList;
import com.sandwich.ingredients.Bread_Slice;
import com.sandwich.ingredients.Cheese_Slice;
import com.sandwich.ingredients.Ham_Slice;
import com.sandwich.ingredients.Mayonnaise;

public class Main {
  public static void main(String[] args) {
    ArrayList<Object> Sandwich = Make_Sandwich();
    System.out.println("This Sandwich Have : ");
    for (Object Ingredient:Sandwich) {
      System.out.println("-> " + Ingredient.getClass());
    }
  }

  public static ArrayList<Object> Make_Sandwich() {
    ArrayList<Object> Sandwich = new ArrayList<>();
    Sandwich.add(new Bread_Slice());
    Sandwich.add(new Mayonnaise());
    Sandwich.add(new Ham_Slice());
    Sandwich.add(new Cheese_Slice());
    Sandwich.add(new Bread_Slice());
    return Sandwich;
  }
}
