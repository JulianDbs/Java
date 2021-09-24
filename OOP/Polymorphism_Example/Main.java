import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Bottle_of_Beer Benderbrau = new Bottle_of_Beer(
      "Benderbrau", new ArrayList<String>(Arrays.asList("Water", "Malt", "Hops", "Yeast"))
    );
    Benderbrau.GetName();
    Benderbrau.DescribeIngredients();
    Benderbrau.Open();
    Benderbrau.Drink();
    Benderbrau.Close();
    Bottle_of_Soda Popsi = new Bottle_of_Soda(
      "Popsi", new ArrayList<String>(Arrays.asList("Carbonated Water", "Caffeine", "Sugar", "More Caffeine", "More Sugar"))
    );
    Popsi.GetName();
    Popsi.DescribeIngredients();
    Popsi.Open();
    Popsi.Drink();
    Popsi.Close();
    Bottle_of_Wine VinPasCher = new Bottle_of_Wine(
      "VinPasCher", new ArrayList<String>(Arrays.asList("Water", "Grape Juice", "Sugar", "Yeast", "Grape Violet 4.66"))
    );
    VinPasCher.GetName();
    VinPasCher.DescribeIngredients();
    VinPasCher.Open();
    VinPasCher.Drink();
    VinPasCher.Close();
    Bottle_of_Water PureMountainWater = new Bottle_of_Water(
      "PureMountainWater", new ArrayList<String>(Arrays.asList("tap water", "Salt"))
    );
    PureMountainWater.GetName();
    PureMountainWater.DescribeIngredients();
    PureMountainWater.Open();
    PureMountainWater.Drink();
    PureMountainWater.Close();
  }
}

public class Bottle {
  public boolean IsOpen;
  public ArrayList<String> Content;

  public Bottle() {
    this.Content = new ArrayList<>();
    this.IsOpen = false;
  }

  public Bottle(ArrayList<String> Content) {
    this.Content = Content;
    this.IsOpen = false;
  }

  public void Open() {
    if (IsOpen) {
      System.out.println("This bottle is already open.");
    } else {
      System.out.println("You open the bottle.");
      this.IsOpen = true;
    }
  }

  public void Close() {
    if (IsOpen) {
      System.out.println("You close the bottle.");
      this.IsOpen = false;
    } else {
      System.out.println("This bottle is already closed.");
    }
  }

  public void Drink() {
    if (IsOpen) {
      if (Content.size() > 0) {
        System.out.println("You are drinking a " + this.getClass().toString().substring(6).replaceAll("_", " ").concat("."));
      } else {
        System.out.println("This bottle is empty.");
      }
    } else {
      System.out.println("This bottle is closed.");
    }
  }

  public void DescribeIngredients() {
    if (Content.size() > 0) {
      System.out.println("The ingredients are : ");
      for (String Ingredient:Content) {
        System.out.println("-> " + Ingredient);
      }
    } else {
      System.out.println("This bottle is empty.");
    }
  }
}

public class Bottle_of_Beer extends Bottle {
  private String Name;

  public Bottle_of_Beer (String Name, ArrayList<String> Content) {
    super(Content);
    this.Name = Name;
  }

  public void GetName() {
    System.out.println("This thing is called '" + Name + "'.");
  }
}

public class Bottle_of_Soda extends Bottle {
  private String Name;
  private boolean CanSleep = true;
  public Bottle_of_Soda(String Name, ArrayList<String> Content) {
    super(Content);
    this.Name = Name;
  }

  public void GetName() {
    System.out.println("This thing is called '" + Name + "'.");
  }

  @Override
  public void Drink() {
    if (IsOpen) {
      if (Content.size() > 0) {
        System.out.println("You are drinking a " + this.getClass().toString().substring(6).replaceAll("_", " ").concat("."));
        CanSleep = false;
      } else {
        System.out.println("This bottle is empty.");
      }
    } else {
      System.out.println("This bottle is closed.");
    }
  }
}

public class Bottle_of_Wine extends Bottle {
  private String Name;

  public Bottle_of_Wine(String Name, ArrayList<String> Content) {
    super(Content);
    this.Name = Name;
  }

  public void GetName() {
    System.out.println("This thing is called '" + Name + "'.");
  }
}

public class Bottle_of_Water extends Bottle {
  private String Name;

  public Bottle_of_Water(String Name, ArrayList<String> Content) {
    super(Content);
    this.Name = Name;
  }

  public void GetName() {
    System.out.println("This thing is called '" + Name + "'.");
  }

  @Override
  public void Drink() {
    if (IsOpen) {
      if (Content.size() > 0) {
        System.out.println("You are drinking a " + this.getClass().toString().substring(6).replaceAll("_", " ").concat("."));
        System.out.println("It's so Healthy!!!.");
      } else {
        System.out.println("This bottle is empty.");
      }
    } else {
      System.out.println("This bottle is closed.");
    }
  }
}
