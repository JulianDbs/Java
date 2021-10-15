import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import com.airplane.Airplane;
import com.airplane.Passenger;

public class Main {
  public static void main(String[] args) {
    Airplane airplane = new Airplane();
    GetPassengerStatistics(airplane);
    GetFlightOccupancy(airplane);
    GetAvailableSeats(airplane);
    GetPassengerList(airplane);
  }

  public static void GetPassengerList(Airplane airplane) {
    System.out.println("(Get Passenger List).");
    Consumer<Passenger> printPassenger = P -> System.out.println(
    "First Name : " + P.FirstName + " | Last Name : " + P.LastName +
    " | Seat : " + P.Seat);
    System.out.println("First Class Passenger List : ");
    List<Passenger> list = airplane.GetPassengerList(c -> c.stream()
      .filter(P -> P.seatClass == Passenger.SeatClass.FirstClass)
      .collect(Collectors.toCollection(ArrayList<Passenger>::new))
    );
    list.stream().forEach(printPassenger);
    System.out.println("Business Class Passenger List : ");
    list = airplane.GetPassengerList(c -> c.stream()
      .filter(P -> P.seatClass == Passenger.SeatClass.Business)
      .collect(Collectors.toCollection(ArrayList<Passenger>::new))
    );
    list.stream().forEach(printPassenger);
    System.out.println("Economy Plus Class Passenger List : ");
    list = airplane.GetPassengerList(c -> c.stream()
      .filter(P -> P.seatClass == Passenger.SeatClass.EconomyPlus)
      .collect(Collectors.toCollection(ArrayList<Passenger>::new))
    );
    list.stream().forEach(printPassenger);
    System.out.println("Economy Class Passenger List : ");
    list = airplane.GetPassengerList(c -> c.stream()
      .filter(P -> P.seatClass == Passenger.SeatClass.Economy)
      .collect(Collectors.toCollection(ArrayList<Passenger>::new))
    );
    list.stream().forEach(printPassenger);
  }

  public static void GetPassengerStatistics(Airplane airplane) {
    System.out.println("(Get Passenger Statistics).");
    long numberOfPassengers = airplane.GetPassengerStatistics(
      pL -> pL.stream().count()
    );
    System.out.println("Number of Passengers : " + numberOfPassengers);
    long adults = airplane.GetPassengerStatistics(
      pL -> pL.stream().filter(P -> P.Age >= 18 && P.Age < 60).count()
    );
    System.out.println("Adults : " + adults);
    long kids = airplane.GetPassengerStatistics(
      pL -> pL.stream().filter(P -> P.Age < 18).count()
    );
    System.out.println("Kids : " + kids);
    long olderPeople = airplane.GetPassengerStatistics(
      pL -> pL.stream().filter(P -> P.Age >= 60).count()
    );
    System.out.println("Older People : " + olderPeople);
  }

  public static void GetFlightOccupancy(Airplane airplane) {
    System.out.println("(Get Flight Occupancy).");
    long firstClassSeats = airplane.GetPassengerStatistics(
      pL -> pL.stream()
      .filter(P -> P.seatClass == Passenger.SeatClass.FirstClass)
      .count()
    );
    System.out.println("First Class Seats : " + firstClassSeats + "/" + Airplane.maxFirstClassSeats);
    long businessClassSeats = airplane.GetPassengerStatistics(
      pL -> pL.stream()
      .filter(P -> P.seatClass == Passenger.SeatClass.Business)
      .count()
    );
    System.out.println("Business Class Seats : " + businessClassSeats + "/" + Airplane.maxBusinessClassSeats);
    long economyPlusClassSeats = airplane.GetPassengerStatistics(
      pL -> pL.stream()
      .filter(P -> P.seatClass == Passenger.SeatClass.EconomyPlus)
      .count()
    );
    System.out.println("Economy Class Seats : " + economyPlusClassSeats + "/" + Airplane.maxEconomyPlusClassSeats);
    long economyClassSeats = airplane.GetPassengerStatistics(
      pL -> pL.stream()
      .filter(P -> P.seatClass == Passenger.SeatClass.Economy)
      .count()
    );
    System.out.println("Economy Class Seats : " + economyClassSeats + "/" + Airplane.maxEconomyClassSeats);
  }

  public static void GetAvailableSeats(Airplane airplane) {
    System.out.println("(Get Available Seats).");
    ArrayList<String> economyPlusExtraSeats = new ArrayList<>(Arrays.asList(
    "B33", "C33", "D33", "E33", "F33", "G33", "H33", "J33", "A45", "B45", "C45",
    "D48", "E48", "F48", "G48", "H45", "J45", "K45"
    ));
    Predicate<Passenger.Seats> firstClassFilter =
      S -> Integer.parseInt(S.name().substring(1)) <= 4;
    Predicate<Passenger.Seats> businessClassFilter =
      S -> Integer.parseInt(S.name().substring(1)) >= 6 &&
      Integer.parseInt(S.name().substring(1)) < 18;
    Predicate<Passenger.Seats> economyPlusClassFilter =
      S -> Integer.parseInt(S.name().substring(1)) >= 19 &&
      Integer.parseInt(S.name().substring(1)) < 26 ||
      economyPlusExtraSeats.contains(S.name());
    Predicate<Passenger.Seats> economyClassFilter =
      S -> Integer.parseInt(S.name().substring(1)) >= 33 &&
       !economyPlusExtraSeats.contains(S.name());
    Function<List<Passenger>, ArrayList<Passenger.Seats>> passengerSeats =
    passengerList -> passengerList.stream()
      .map(P -> P.Seat)
      .collect(Collectors.toCollection(ArrayList<Passenger.Seats>::new));
    BiFunction<List<Passenger.Seats>, ArrayList<Passenger.Seats>, List<Passenger.Seats>> filterSeats =
    (seatsList, passengerSeatsList) -> seatsList.stream()
      .filter(S -> !passengerSeatsList.contains(S))
      .filter(firstClassFilter)
      .collect(Collectors.toCollection(ArrayList<Passenger.Seats>::new));
    List<Passenger.Seats> list = airplane.GetAvailableSeats(passengerSeats, filterSeats);
    System.out.println("Fist Class Avaliable Seats : ");
    ShowList(list);
    filterSeats = (seatsList, passengerSeatsList) -> seatsList.stream()
      .filter(S -> !passengerSeatsList.contains(S))
      .filter(businessClassFilter)
      .collect(Collectors.toCollection(ArrayList<Passenger.Seats>::new));
    list = airplane.GetAvailableSeats(passengerSeats, filterSeats);
    System.out.println("Business Class Avaliable Seats : ");
    ShowList(list);
    filterSeats = (seatsList, passengerSeatsList) -> seatsList.stream()
      .filter(S -> !passengerSeatsList.contains(S))
      .filter(economyPlusClassFilter)
      .collect(Collectors.toCollection(ArrayList<Passenger.Seats>::new));
    list = airplane.GetAvailableSeats(passengerSeats, filterSeats);
    System.out.println("Economy Plus Class Avaliable Seats : ");
    ShowList(list);
    filterSeats = (seatsList, passengerSeatsList) -> seatsList.stream()
      .filter(S -> !passengerSeatsList.contains(S))
      .filter(economyClassFilter)
      .collect(Collectors.toCollection(ArrayList<Passenger.Seats>::new));
    list = airplane.GetAvailableSeats(passengerSeats, filterSeats);
    System.out.println("Economy Class Avaliable Seats : ");
    ShowList(list);
  }

  public static void ShowList(List<Passenger.Seats> list) {
    if (list.size() < 10) {
      list.forEach(e -> System.out.print(" | " + e));
      System.out.println(" |\r");
    } else {
      int Count = list.size() / 10;
      Iterator<Passenger.Seats> iterator = list.iterator();
      for (int i = 0; i < Count + 1; i++) {
        if (iterator.hasNext()) {
          for (int a = 0; a < 10; a ++) {
            if (iterator.hasNext()) {
              System.out.print(" | " + iterator.next());
            }
          }
          System.out.println(" | \r");
        }
      }
    }
  }
}
