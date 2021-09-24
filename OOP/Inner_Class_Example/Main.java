import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    CheetosRevolver Gun = new CheetosRevolver();
    Gun.Reload();
    Gun.GetGunAmmunationCount();
    for (int i = 0; i < 8; i++) {
      Gun.Shoot();
      Gun.GetGunAmmunationCount();
    }
    Gun.Reload();
    Gun.GetGunAmmunationCount();
  }
}

public class CheetosRevolver {

  private class RevolverChamber {
    private ArrayList<Cheeto> Chamber;

    public RevolverChamber() {
      Chamber = new ArrayList<Cheeto>();
    }

    public void Reload() {
      System.out.println("Reloading ...");
      int Count = 0; int CurrentAmmunation = Chamber.size();
      for (int i = 0; i < (6 - CurrentAmmunation); i++) {
        Chamber.add(new Cheeto());
        Count ++;
      }
      System.out.println("You load " + Count + " Cheetos into the chamber.");
    }

    public int GetAmmunationCount() {
      return Chamber.size();
    }

    public void ShootCheeto() {
      Chamber.remove((Chamber.size() - 1));
    }
  }

  private RevolverChamber Chamber;

  public CheetosRevolver() {
    Chamber = new RevolverChamber();
  }

  public void Shoot() {
    System.out.println("Shooting ...");
    if (Chamber.GetAmmunationCount() > 0) {
      System.out.println("You fired the gun.");
      Chamber.ShootCheeto();
    } else {
      System.out.println("Click! Click!, The gun is empty!!!!");
    }
  }

  public void GetGunAmmunationCount() {
    System.out.println("You have " + Chamber.GetAmmunationCount() + " cheetos in the chamber.");
  }

  public void Reload() {
    Chamber.Reload();
  }
}

public class Cheeto {
  private int Damage;

  public Cheeto () {
    this.Damage = 999;
  }
}
