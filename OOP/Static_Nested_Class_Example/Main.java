public class Main {
  public static void main(String[] args) {
    Android_MK_I B700 = new Android_MK_I("B700");
    B700.WhoAreYou();
    Android_MK_I B855 = new Android_MK_I("B855");
    B855.WhoAreYou();
    Android_MK_I A765 = new Android_MK_I("A765");
    A765.WhoAreYou();
  }
}

public class Android_MK_I {
  private String Name;
  public static String Model;
  private Core AndroidCore;

  public Android_MK_I(String Name) {
    this.Name = Name;
    Model = "MK I";
    AndroidCore = new Core();
  }

  private static class Core {
    public static void DeclareUnitIdentification(Android_MK_I Unit) {
      System.out.println("Hello Human, I'm unit " + Unit.Name + ", Model " + Model + "\nExterminate !!!!!!");
    }
  }

  public void WhoAreYou() {
    Core.DeclareUnitIdentification(this);
  }
}
