import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;

public class Main {
  public static void main(String[] args) {
    Product[] productList = {new Ketchup(), new Mayonnaise(), new Oreos()};
    describeProducts(productList);
  }

  public static void describeProducts(Product[] productsList) {
    for (Product product : productsList) {
      System.out.println("Product : " + product.getClass().getSimpleName());
      System.out.println(
        "\nNutrition Facts (100g) : " +
        "\n\tSodium\t : " + product.SodiumContentValue +
        "\n\tSugars\t : " + product.SugarContentValue +
        "\n\tCalories : " + product.CalorieContentValue +
        "\n\tFat\t : " + product.FatContentValue
      );
      getLabels(product);
    }
  }

  public static void getLabels(Product product) {
    if (product == null) {
      System.out.println("This Object is null.");
    } else {
      ProductLabel[] list = product.getClass().getAnnotationsByType(ProductLabel.class);
      if (list.length > 0) {
        System.out.println("\nProduct Labels : ");
        for (ProductLabel productLabel : list) {
          System.out.println("\t-> " + productLabel.label());
        }
        System.out.println("\n");
      } else {
        System.out.println("This Product has no Labels.");
      }
    }
  }
}

/**
*This annotation is used to warn about the high sodium, sugar,
*calories and fat content in a product.
*15g of sugar in 100g is considered high sugar content.
*20% of sodium in 100g is considered high sodium content.
*200kcal of calorie in 100g is considered high calorie content.
*20g of fat in 100g is considered hig fat content.
*/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(ProductLabels.class)
public @interface ProductLabel {
  public String label() default "N/A";
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ProductLabels {
  public ProductLabel[] value();
}

public class Product {
  public final String SodiumContentValue;
  public final String SugarContentValue;
  public final String CalorieContentValue;
  public final String FatContentValue;

  public Product(
    final String SodiumContentValue,
    final String SugarContentValue,
    final String CalorieContentValue,
    final String FatContentValue
  ) {
    this.SodiumContentValue = SodiumContentValue;
    this.SugarContentValue = SugarContentValue;
    this.CalorieContentValue = CalorieContentValue;
    this.FatContentValue = FatContentValue;
  }
}

@ProductLabel(label = "High Sodium Content.")
public class Ketchup extends Product{
  public Ketchup() {
    super("1140g", "18g", "90", "0g");
  }
}

@ProductLabel(label = "High Sodium Content")
@ProductLabel(label = "High Calorie Content")
@ProductLabel(label = "High Fat Content")
public class Mayonnaise extends Product {
  public Mayonnaise(){
    super("720mg", "0g", "720", "80g");
  }
}

@ProductLabel(label = "High Sugar Content")
@ProductLabel(label = "High Calorie Content")
@ProductLabel(label = "High Fat Content")
public class Oreos extends Product {
  public Oreos() {
    super("405mg", "42g", "480", "21g");
  }
}
