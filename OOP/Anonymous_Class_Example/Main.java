import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
  public static void main(String[] args) {
      StarShip Ship = new StarShip("Agamemnon");
      Ship.SelftDestructionProtocol(Ship);
  }
}

public class StarShip {
  public String Name;
  private ArrayList<String> NavigationDiary;
  private ArrayList<String> CrewList;
  private ArrayList<String> CargoManifest;

  public StarShip(String Name) {
    this.Name = Name;
    NavigationDiary = new ArrayList<>();
    CrewList = new ArrayList<>();
    CargoManifest = new ArrayList<>();
  }

  interface SelftDestructionProtocol {
    public abstract void StartProtocol(StarShip Ship);
  }

  public void SelftDestructionProtocol(StarShip Ship) {
    SelftDestructionProtocol Protocol = new SelftDestructionProtocol() {

      @Override
      public void StartProtocol(StarShip Ship) {
        System.out.println("Ship " + Ship.Name + " | Selft Destruction Protocol | Start.");
        ClearNavigationDiary(Ship.NavigationDiary);
        ClearCrewList(Ship.CrewList);
        ClearCargoManifest(Ship.CargoManifest);
        StartReactorOverload();
      }

      private void ClearNavigationDiary(ArrayList<String> Diary) {
        Diary.clear();
        System.out.println("-> Navigation Diary Deleted.");
      }

      private void ClearCrewList(ArrayList<String> Diary) {
        Diary.clear();
        System.out.println("-> Crew List Deleted.");
      }

      private void ClearCargoManifest(ArrayList<String> Manifest) {
        Manifest.clear();
        System.out.println("-> Cargo Manifest Deleted.");
      }

      private void StartReactorOverload() {
        System.out.println("Ship " + Ship.Name + " | Reactor Overload | Start.");
        /*
        int Count = 20;
        for (int i = 0; i < 200000; i++) {
          switch(i) {
            case 200000: case 190000: case 180000: case 170000: case 160000:
            case 150000: case 140000: case 130000: case 120000: case 110000:
            case 100000: case 90000: case 80000: case 70000: case 60000:
            case 50000: case 40000: case 30000: case 20000: case 10000: Count -= 1 ; break;
          }
          System.out.print("\r-> Detonation in " + Count + "\r");
          if (i == 199999) {
            System.out.println("\nBye.\nBOOOMMMMMM!!!!!");
            break;
          }
        }
        */
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
          int i = 30;
          @Override public void run() {
            System.out.print("\033[2K\r-> Detonation in " + String.valueOf(i) + "s");
            i--;
            if (i < 0) {
              timer.cancel();
              System.out.println("\nBye.\nBOOOMMMMMM!!!!!");
            }
          }
        },0 ,1000);
      }
    };
    Protocol.StartProtocol(Ship);
  }
}
