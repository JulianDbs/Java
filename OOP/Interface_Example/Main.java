public class Main {
  public static void main(String[] args) {
    Test_Door();
    Test_Secure_Door();
  }

  public static void Test_Door() {
    System.out.println("Testing Door ...");
    Door Test_Door = new Door();
    Test_Door.GetDoorColor();
    Test_Door.Open();
    Test_Door.Open();
    Test_Door.Close();
    Test_Door.Close();
  }

  public static void Test_Secure_Door() {
    System.out.println("Testing Secure Door ...");
    Secure_Door Test_Secure_Door = new Secure_Door("Red");
    Test_Secure_Door.GetDoorColor();
    Test_Secure_Door.Open();
    Test_Secure_Door.Unlock();
    Test_Secure_Door.Open();
    Test_Secure_Door.Open();
    Test_Secure_Door.Lock();
    Test_Secure_Door.Close();
    Test_Secure_Door.Close();
    Test_Secure_Door.Lock();
    Test_Secure_Door.Open();
  }
}

public class Door {
  private String Color;
  private boolean DoorOpen;

  public Door() {
    this.Color = "Grey";
    DoorOpen = false;
  }

  public Door(String Color) {
    this.Color = Color;
    DoorOpen = false;
  }

  public void Open() {
    System.out.println("Open ...");
    if (DoorOpen) {
      System.out.println("This door is already open.");
    } else {
      System.out.println("Door Open.");
      DoorOpen = !DoorOpen;
    }
  }

  public void Close() {
    System.out.println("Close ...");
    if (DoorOpen) {
      System.out.println("Door Closed.");
      DoorOpen = !DoorOpen;
    } else {
      System.out.println("This door is already closed.");
    }
  }

  public void GetDoorColor() {
    System.out.println("This Door is " + Color);
  }

  public boolean IsDoorOpen() {
    return DoorOpen;
  }
}

public interface Door_Interface {
  public abstract void Unlock();
  public abstract void Lock();
}

public final class Secure_Door extends Door implements Door_Interface {
  private boolean LockedDoor;
  private boolean DoorOpen;

  public Secure_Door(String Color) {
    super(Color);
    LockedDoor = true;
    this.DoorOpen = false;
  }

  @Override
  public void Unlock() {
    System.out.println("Unlock ...");
    System.out.println("This door is now unlocked.");
    LockedDoor = false;
  }

  @Override
  public void Lock() {
    System.out.println("Lock ...");
    if (this.DoorOpen) {
      System.out.println("First close the door.");
    } else {
      System.out.println("This door is now locked.");
      LockedDoor = true;
    }
  }

  @Override
  public void Open() {
    System.out.println("Open ...");
    if (LockedDoor) {
      System.out.println("This door is locked.");
    } else {
      if (DoorOpen) {
        System.out.println("This door is already open.");
      } else {
        System.out.println("Door open.");
        this.DoorOpen = true;
      }
    }
  }

  @Override
  public void Close() {
    System.out.println("Close ...");
    if (DoorOpen) {
      System.out.println("Door Closed.");
      this.DoorOpen = false;
    } else {
      System.out.println("This door is already closed.");
    }
  }
}
