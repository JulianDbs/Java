import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    ParallelTest test = new ParallelTest();
    test.startTest();
  }
}

public class Product {
  public enum ProductType {Pasta, Rice}
  public final ProductType productType;
  public final LocalDate expirationDate;
  public final String productId;

  public Product(
    final ProductType productType,
    final LocalDate expirationDate,
    final String productId
  ) {
    this.productType = productType;
    this.expirationDate = expirationDate;
    this.productId = productId;
  }
}

public interface ParallelTestTools {
  public default LocalDate getDate(boolean expired) {
    LocalDate currentDate = LocalDate.now();
    int year = currentDate.getYear();
    int month = currentDate.getMonthValue();
    int day = currentDate.getDayOfMonth();
    year = (expired)? (year -1) : (year + 2);
    String update = new String(String.valueOf(day).concat("/").concat(String.valueOf(month)).concat("/").concat(String.valueOf(year)));
    currentDate = LocalDate.parse(update, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    return currentDate;
  }

  public default String buildId(
    int shipment,
    int container,
    int box,
    int product
  ) {
    return new String(shipment + "-" + container + "-" + box + "-" + product);
  }

  public default void cleanScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}


public class ParallelTest implements ParallelTestTools {
  private  ArrayList<Product> productList, expiredProducts;
  private  ArrayList<Product> parallelTestResult, streamTestResult;
  private long parallelTestTime, streamTestTime;

  public ParallelTest() {
    productList = new ArrayList<Product>();
    expiredProducts = new ArrayList<Product>();
    parallelTestResult = new ArrayList<Product>();
    streamTestResult = new ArrayList<Product>();
    parallelTestTime = 0; streamTestTime = 0;
  }

  public void  startTest() {parallelTestStage_0();}

  private void parallelTestStage_0() {
    cleanScreen();
    Scanner scanner = new Scanner(System.in);
    System.out.println("| Parallel Test |\n" +
      "This test will build a list of 8 million products (packages of rice or pasta).\n" +
      "Each product will have a shipping number, container number, box number, product number,\n" +
      "a product type, and an expiration date.\n" +
      "In the process of building the list some expired products will be added.\n" +
      "Then those expired products will be searched in the list using 'Aggregate Operations',\n" +
      "first using a 'Parallel Stream' and then using a 'Stream'.\n" +
      "At the end, the time taken for each search and the results of both will be compared.\n"
    );
    System.out.print("Select Command : \nPress 'y' and Enter to Start the Test.\nPress 'q' and Enter to Quit.\nCommand : ");
    if (scanner.hasNext()) {
      switch(scanner.next().toString().toLowerCase()) {
        case "y":parallelTestStage_1();break;
        case "q":System.exit(0);break;
        default:System.out.print("\r");parallelTestStage_0();break;
      }
    }
  }

  private void parallelTestStage_1() {
    cleanScreen();
    System.out.print("| Parallel Test |\nSelect Command : \nPress 'y' and Enter to build the Products List.\nPress 'q' and Enter to Quit.\nCommand : ");
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNext()) {
      switch(scanner.next().toString().toLowerCase()) {
        case "y":
          addProducts();
          parallelTestStage_2();
          break;
        case "q":
          clearArrays();
          System.exit(0);
          break;
        default:System.out.print("\r");parallelTestStage_1();break;
      }
    }
  }

  private void parallelTestStage_2() {
    cleanScreen();
    System.out.println("| Parallel Test |\nProducts on the List : " + productList.size());
    System.out.println("Expired Products on the List : " + expiredProducts.size());
    System.out.print("Select Command : \nPress 'y' and Enter to start the Stream Parallel Test.\nPress 'q' and Enter to Quit.\nCommand : ");
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNext()) {
      switch(scanner.next().toString()) {
        case "y":
          testParallelStream();
          parallelTestStage_3();
          break;
        case "q":
          clearArrays();
          System.exit(0);
          break;
        default:System.out.print("\r");parallelTestStage_2();break;
      }
    }
  }

  private void parallelTestStage_3() {
    cleanScreen();
    System.out.println("| Parallel Test |\nProducts on the List : " + productList.size());
    System.out.println("Expired Products on the List : " + expiredProducts.size());
    System.out.print("Select Command : \nPress 'y' and Enter to start the Stream Test.\nPress 'q' and Enter to Quit.\nCommand : ");
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNext()) {
      switch(scanner.next().toString()) {
        case "y":
          testStream();
          parallelTestStage_4();
          ;break;
        case "q":
          clearArrays();
          System.exit(0);
          break;
        default:System.out.print("\r");parallelTestStage_3();break;
      }
    }
  }

  private void parallelTestStage_4() {
    cleanScreen();
    System.out.println("| Parallel Test |\nTest Finished.");
    System.out.print("Select Command : \nPress 'y' and Enter to show the result of test.\nPress 'q' and Enter to Quit.\nCommand : ");
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNext()) {
      switch(scanner.next().toString()) {
        case "y":
          cleanScreen();
          showResults();
          break;
        case "q":
          clearArrays();
          System.exit(0);
          break;
        default:System.out.print("\r");parallelTestStage_3();break;
      }
    }
    System.out.print("\nPress Any Key to Quit ...");
    scanner = new Scanner(System.in);
    scanner.nextLine();
    clearArrays();
    System.exit(0);
  }

  private void addProducts() {
    int count = -1; int expired = 0;
    boolean invert = false;
    for (int shipment = 0; shipment < 8; shipment++) {
      for (int container = 0; container < 10; container++) {
        boolean trigger = true;
        System.out.print( (invert)? "\rBuilding List (-_-)" : "\rBuilding List (0_0)"); invert = !invert;
        for (int box = 0; box < 1000; box++) {
          for (int product = 0; product < 100; product++) {
            productList.add(
              new Product(
                (trigger)? Product.ProductType.Pasta : Product.ProductType.Rice,
                (expired == 387654)? getDate(true) : getDate(false),
                buildId(shipment, container, box, product)
              )
            );
            count++;
            if (expired == 387654) {
              expiredProducts.add(productList.get(count));
            }
            expired = (expired >= 387654)? 0 : (expired + 1);
          }
          trigger = !trigger;
        }
      }
    }
  }

  private void testParallelStream() {
    long start = System.currentTimeMillis();
    LocalDate currentDate = LocalDate.now();
    parallelTestResult = productList.parallelStream()
      .filter(p -> p.expirationDate.isBefore(currentDate))
      .collect(Collectors.toCollection(ArrayList<Product>::new));
    long end = System.currentTimeMillis();
    parallelTestTime = (end - start);
  }

  private void testStream() {
    long start = System.currentTimeMillis();
    LocalDate currentDate = LocalDate.now();
    streamTestResult = productList.stream()
    .filter(p -> p.expirationDate.isBefore(currentDate))
    .collect(Collectors.toCollection(ArrayList<Product>::new));
    long end = System.currentTimeMillis();
    streamTestTime = (end - start);
  }

  private void showExpiredProducts(ArrayList<Product> expiredProducts) {
    System.out.println("Expired Products : " + expiredProducts.size());
    for (Product p : expiredProducts) {
      String[] idData = p.productId.split("-");
    System.out.println("| Type : " + p.productType +
        "\t| Expiration Date : " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(p.expirationDate) +
        "\t|\n| Shipment Number : " + idData[0] +
        "\t| Container Number : " + idData[1] +
        "\t| Box Number : " + idData[2] +
        "\t| Product Number : " + idData[3] + " |\n"
      );
    }
  }

  private void showResults() {
    System.out.println("Results \nProducts on the List : " + productList.size());
    System.out.println("Current Date : " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now()));
    System.out.println("Expired Products on the List : " + expiredProducts.size() + "\n");
    showExpiredProducts(expiredProducts);
    System.out.println("Parallel Test Time " + parallelTestTime + " milliseconds.\n\nParallel Test Result : ");
    showExpiredProducts(parallelTestResult);
    System.out.println("Stream Test Time : " + streamTestTime + " milliseconds.\n\nStream Test Result : ");
    showExpiredProducts(streamTestResult);
  }

  private void clearArrays() {
    productList.clear();
    expiredProducts.clear();
    parallelTestResult.clear();
    streamTestResult.clear();
  }
}
