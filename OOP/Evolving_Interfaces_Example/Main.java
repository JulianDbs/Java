public class Main {
  public static void main(String[] args) {
    Test_Old_Tv();
    Test_Modern_Tv();
  }

  public static void Test_Old_Tv() {
    System.out.println("Testing Old Tv ...");
    Old_Tv Test_Old_Tv = new Old_Tv();
    Test_Old_Tv.GetInterfaceVersion();
    Test_Old_Tv.Turn_On_Tv();
    Test_Old_Tv.Change_Channel();
    Test_Old_Tv.Turn_Off_Tv();
  }

  public static void Test_Modern_Tv() {
    System.out.println("Testing Modern Tv ...");
    Modern_Tv Test_Modern_Tv = new Modern_Tv();
    Test_Modern_Tv.GetInterfaceVersion();
    Modern_Tv_Interface.HowTurnOnTheTv();
    Test_Modern_Tv.Turn_On_Tv();
    Modern_Tv_Interface.HowChangeTheCurrentChannel();
    Test_Modern_Tv.Change_Channel();
    Modern_Tv_Interface.HowWatchNetflix();
    Test_Modern_Tv.Watch_Netflix();
    Modern_Tv_Interface.HowWatchYouTube();
    Test_Modern_Tv.Watch_YouTube();
    Modern_Tv_Interface.HowTurnOffTheTv();
    Test_Modern_Tv.Turn_Off_Tv();
  }
}

public interface Old_Tv_Interface {
  public abstract void Turn_On_Tv();
  public abstract void Turn_Off_Tv();
  public abstract void Change_Channel();
  public default void GetInterfaceVersion() {
    System.out.println("Interface Version 0.1");
  }
}

public class Old_Tv implements Old_Tv_Interface {
  public Old_Tv() {}

  @Override
  public void Turn_On_Tv() {
    System.out.println("(Turn On Tv).");
    System.out.println("The tv is On.");
  }

  @Override
  public void Turn_Off_Tv() {
    System.out.println("(Turn Off Tv).");
    System.out.println("The tv is Off.");
  }

  @Override
  public void Change_Channel() {
    System.out.println("(Change Channel).");
    System.out.println("Channel changed.");
  }
}

public interface Modern_Tv_Interface extends Old_Tv_Interface {
  public default void GetInterfaceVersion() {
    System.out.println("Interface Version 0.2");
  }

  public static void HowTurnOnTheTv() {
    System.out.println("(How Turn On The Tv).");
    System.out.println("Execute 'Turn_On_Tv()'.");
  }

  public static void HowTurnOffTheTv() {
    System.out.println("(How Turn Off The Tv).");
    System.out.println("Execute 'Turn_Off_Tv()'.");
  }

  public static void HowChangeTheCurrentChannel() {
    System.out.println("(How Change The Current Channel).");
    System.out.println("Execute 'Change_Channel()'.");
  }

  public static void HowWatchNetflix() {
    System.out.println("(How Watch Netflix).");
    System.out.println("Execute 'Watch_Netflix()'.");
  }

  public static void HowWatchYouTube() {
    System.out.println("(How Watch YouTube).");
    System.out.println("Execute 'Watch_YouTube()'.");
  }

  public abstract void Watch_Netflix();
  public abstract void Watch_YouTube();
}

public class Modern_Tv implements Modern_Tv_Interface {
  public Modern_Tv() {}

  @Override
  public void Watch_Netflix() {
    System.out.println("(Watch Netflix).");
    System.out.println("Tudummmmm");
  }

  @Override
  public void Watch_YouTube() {
    System.out.println("(Watch YouTube).");
    System.out.println("Get now YouTube Premium and we will let you finish listening to this song.");
  }

  @Override
  public void Turn_On_Tv() {
    System.out.println("(Turn On Tv).");
    System.out.println("The tv is On.");
  }

  @Override
  public void Turn_Off_Tv() {
    System.out.println("(Turn Off Tv).");
    System.out.println("The tv is Off.");
  }

  @Override
  public void Change_Channel() {
    System.out.println("(Change Channel).");
    System.out.println("Channel changed.");
  }
}
