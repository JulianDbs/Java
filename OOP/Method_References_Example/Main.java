import java.util.function.Supplier;
import java.util.function.BiFunction;

public class Main {
  public static void main(String[] args) {
    Cat cat = new Cat("Mr. Frodo");
    cat.getAffection(cat::meow, LazyAndSybarite15thCenturyMonarch::demandAffection, String::concat);
    cat.getFood(cat::meow, LazyAndSybarite15thCenturyMonarch::demandFood, String::concat);
    cat.feedTheCat(cat::meow, CatFood::new, cat::getName);
  }
}

public interface LazyAndSybarite15thCenturyMonarch {
  public static String demandFood() {return "commoner I order you to give me food !!!";}
  public static String demandAffection() {return "feel grateful commoner, I'll let you scratch my neck and ear.";}
}

public interface Felidae {
  public default String meow() {return "Meowww ";}
  public abstract void sleep();
}

public class CatFood {
  private String name;

  public CatFood(){name = "Whisquazzz";}

  public String getFoodName() {return name;}
}

public class Cat implements Felidae, LazyAndSybarite15thCenturyMonarch {
  private String name;

  public Cat() {
    name = "Cat";
  }

  public Cat(String name) {
    this.name = name;
  }

  public String getName() {return name;}

  public void getFood(Supplier<String> s_0, Supplier<String> s_1, BiFunction<String, String, String> bf) {
    System.out.println(bf.apply(s_0.get(), s_1.get()));
  }

  public void getAffection(Supplier<String> s_0, Supplier<String> s_1, BiFunction<String, String, String> bf) {
    System.out.println(bf.apply(s_0.get(), s_1.get()));
  }

  public void feedTheCat(Supplier<String> s_0, Supplier<CatFood> s_1, Supplier<String> s_2) {
    System.out.println(s_0.get() + " I, " + s_2.get() + ", am satisfied with the " + s_1.get().getFoodName());
    System.out.println(s_0.get() + " Now go peasant, I must sleep.");
    sleep();
  }

  @Override
  public void sleep() {
    System.out.println(name + " is sleeping now.");
  }

}
