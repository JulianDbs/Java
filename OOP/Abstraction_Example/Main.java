public class Main {
  public static void main(String[] args) {
    Mandarin_Orange Mandarin = new Mandarin_Orange();
    Mandarin.DescribeThisFruit();
    Mandarin.Wash();
    Mandarin.Eat();
  }
}

public abstract class Fruit {
  public void Eat() {
    System.out.println("(Eat)\nYou eat this fruit.");
  }

  public void Wash() {
    System.out.println("(Wash)\nThis fruit is now clean.");
  }

  public abstract void DescribeThisFruit();
}

public class Mandarin_Orange extends Fruit {
  public Mandarin_Orange(){}

  @Override
  public void DescribeThisFruit() {
    System.out.println("(Describe This Fruit)\nThis is an Mandarin Orange.");
  }
}
