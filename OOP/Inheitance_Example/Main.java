public class Main {
  public static void main (String[] args) {
    Batman_1966 B_66 = new Batman_1966(true, false);
    B_66.Jump();
    B_66.Run();
    B_66.LookAround();
    B_66.Dance();
    Batman_1989 B_89 = new Batman_1989(false, true, true);
    B_89.Jump();
    B_89.Run();
    B_89.LookAround();
    B_89.Dance();
    B_89.ImBatman();
  }
}

public class Batman_1966 {
  private boolean HaveARobin;
  private boolean CanKill;

  public Batman_1966(boolean HaveARobin, boolean CanKill) {
    this.HaveARobin = HaveARobin;
    this.CanKill = CanKill;
    System.out.println("Batman !!!");
    System.out.println("Batman have a Robin : " + this.HaveARobin);
    System.out.println("Batman can kill : " + this.CanKill);
  }

  public void Jump() {
    System.out.println("Batman jump.");
  }

  public void Run() {
    System.out.println("Bataman run.");
  }

  public void LookAround() {
    System.out.println("Batman looks around.");
  }

  public void Dance() {
    StartDance();
  }

  private void StartDance() {
    System.out.println("Batman make 'The Batusi'.");
  }
}

public class Batman_1989 extends Batman_1966 {
  private boolean RigidMask;

  public Batman_1989(boolean HaveARobin, boolean CanKill, boolean RigidMask) {
    super(HaveARobin, CanKill);
    this.RigidMask = RigidMask;
    System.out.println("Batman have a rigid mask : " + RigidMask);
  }

  public void ImBatman() {
    System.out.println("Batman says I'm Batman.");
  }

  @Override
  public void LookAround() {
    if (RigidMask) {
      System.out.println("Batman can't turn his head, it's hard to be Batman.");
    } else {
      System.out.println("Batman looks around.");
    }
  }

  @Override
  public void Dance() {
    System.out.println("Batman doesn't dance.");
  }
}
