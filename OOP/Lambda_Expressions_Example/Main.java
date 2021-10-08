import com.burger.ingredients.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Main {
  public static void main(String[] args) {
    ArrayList<ArrayList<Ingredient>> AllTheBurgesInTheRestaurant = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      AllTheBurgesInTheRestaurant.add(new ArrayList<>(Arrays.asList(
      new BurgerBun(),new CheddarCheese(), new BurgerPatty(),
      new Ketchup(), new Lettuce(), new BurgerBun())
      ));
    }
    System.out.println("(Start Crusade).");
    Purge(AllTheBurgesInTheRestaurant);
  }

  public static void Purge(ArrayList<ArrayList<Ingredient>> AllTheBurgesInTheRestaurant) {
    class Templar {
      private int lvl;

      public Templar() {
        lvl = 999;
      }

      public void StartCrusade(
        ArrayList<ArrayList<Ingredient>> burgers,
        Consumer<Integer> restProtocol
      ) {
        int purgedLettuces = 0;
        for (ArrayList<Ingredient> burger:burgers) {
          boolean purged = ExamineBurger(
            burger,
            (i) -> burger.get(i).getClass().getSimpleName().equals("Lettuce")
          );
          if (purged) purgedLettuces++;
        }
        restProtocol.accept(purgedLettuces);
      }

      private boolean ExamineBurger(
        ArrayList<Ingredient> burger,
        Predicate<Integer> haveLettuce
      ) {
        boolean Lettuce = false;
        for (int i = 0; i < burger.size(); i++) {
          if (haveLettuce.test(i)) {
            Lettuce = true;
            burger.remove(i);
          }
        }
        return Lettuce;
      }
    }

    Templar Robert = new Templar();
    Robert.StartCrusade(
    AllTheBurgesInTheRestaurant,
    (pl) -> System.out.println(pl + " Lettuces have been eradicated.\nMy work is done ... now i must rest.")
    );
  }
}
