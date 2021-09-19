public class Main {
  public static void main(String[] args) {
    Stout_Beer beer = new Stout_Beer();
    beer.Drink();
    beer.Open();
    beer.Drink();
  }
}

public class Stout_Beer {
    private boolean Closed_Bottle = true;
    final int ABV = 8;

    public Stout_Beer() {
      System.out.println("World : A bottle of beer just appeared in front of you, don't ask.");
    }

    public void Open() {
      Closed_Bottle = false;
      System.out.println("You : You open the bottle.");
    }

    public void Drink() {
      System.out.println("You : You start trying to drink.");
      if (Closed_Bottle) {
        System.out.println("World : ¿Why don't you try to open the bottle first?.");
      } else {
          System.out.println("World : ¿How can you drink that?. \nWorld : You don't know where it come from !!!");
      }
    }
}
