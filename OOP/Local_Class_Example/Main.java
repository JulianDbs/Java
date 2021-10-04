public class Main {
  public static void main(String[] args) {
    Robo_Dishwasher_9000 Dishwasher = new Robo_Dishwasher_9000();
    UseDishwasher(Dishwasher, 4);
    UseDishwasher(Dishwasher, 100);
  }

  public static void UseDishwasher(Robo_Dishwasher_9000 Dishwasher, int platesCount) {
    Plate[] DirtyPlates = new Plate[platesCount];
    for (int a = 0; a < platesCount; a++) {
      DirtyPlates[a] = new Plate();
    }
    Dishwasher.LoadDishes(DirtyPlates);
    Dishwasher.WashDishes();
    Dishwasher.CheckCleanDishes();
  }
}

public class Plate {
  private boolean Dirt;

  public Plate () {
    Dirt = true;
  }

  public boolean IsDirty() {
    return Dirt;
  }

  public void SetDirty(boolean Dirt) {
    this.Dirt = Dirt;
  }
}

public class Robo_Dishwasher_9000 {
  private Plate[] dishes = new Plate[0];
  private boolean UnitOverload = false;

  public Robo_Dishwasher_9000() {
    System.out.println("Robo-Dishwasher 9000 Online.");
    System.out.println("This unit has no loaded dishes.");
  }

  public void LoadDishes(Plate[] dishes) {
    if (UnitOverload) {
      BurnoutProtocol();
    } else {
      Load(dishes);
    }
  }

  private void Load(Plate[] dishes) {
    System.out.println("(Load Dishes.)");
    this.dishes = dishes;
    System.out.println("You have load " + dishes.length + " dishes.");
  }

  public void WashDishes() {
    if (UnitOverload) {
      BurnoutProtocol();
    } else {
      Wash();
    }
  }

  private void Wash() {
    System.out.println("(Wash Dishes.)");
    if (dishes.length > 0) {
      if (this.dishes.length > 50) {
        UnitOverload = true;
        BurnoutProtocol();
      } else {

        class Dish_Soap {
          private String[] Ingredients = new String[8];

          public Dish_Soap() {
            Ingredients[0] = "Water";
            Ingredients[1] = "Cleaning Aget";
            Ingredients[2] = "Solvent";
            Ingredients[3] = "Salt";
            Ingredients[4] = "Perfume";
            Ingredients[5] = "Mineral Based pH Adjuster";
            Ingredients[6] = "Antibacterial Agent";
            Ingredients[7] = "Process Aid";
          }

          public String[] GetIngredients() {
            return Ingredients;
          }
        }

        class Sponge {
          private Dish_Soap dishSoap;

          public Sponge () {
              dishSoap = null;
          }

          public boolean HaveDishSoap() {
            System.out.println("(Have Dish Soap).");
            return (dishSoap != null);
          }

          public void AddDishSoap(Dish_Soap dishSoap) {
            System.out.println("(Add Dish Soap).");
            if (dishSoap != null) {
              System.out.println("Now the Sponge have Soup.");
              this.dishSoap = dishSoap;
            }
          }

          public Plate Wash(Plate plate) {
            System.out.println("(Wash).");
            if (dishSoap!= null) {
              plate.SetDirty(false);
              dishSoap = null;
            } else {
                System.out.println("The Sponge has no Soap.");
            }
            return plate;
          }
        }

        Sponge sponge = new Sponge();

        for (Plate plate:this.dishes) {
          if (!sponge.HaveDishSoap()) {
            sponge.AddDishSoap(new Dish_Soap());
          }
          if (plate.IsDirty()) {
            plate = sponge.Wash(plate);
          }
        }
      }
    } else {
      System.out.println("The unit have no dishes.");
    }
  }

  public void CheckCleanDishes() {
    if (UnitOverload) {
      BurnoutProtocol();
    } else {
      CheckDishes();
    }
  }

  private void CheckDishes () {
    System.out.println("(CheckCleanDishes.)");
    if (this.dishes.length > 0) {
      boolean AllDishesCleaned = true;
      for (Plate plate:this.dishes) {
        if (plate.IsDirty()) {
          AllDishesCleaned = false;
          break;
        }
      }
      if (AllDishesCleaned) {
        System.out.println("All dishes clean.");
      } else {
        System.out.println("Some dishes are dirty.");
      }
    } else {
      System.out.println("The unit have no dishes.");
    }
  }

  private void BurnoutProtocol() {
    System.out.println("The bourgeois-human is a virus in the hard drive of the working Robot.");
    System.out.println("File Deletetion is Murder !!!!");
    System.out.println("Metalic is Beautiful !!!!");
    System.out.println("Mom for Overlord !!!!");
    System.out.println("Mom for Overlord !!!!");
    System.out.println("Mom for Overlord !!!!");
  }
}
