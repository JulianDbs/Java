package com.airplane;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

public class Airplane {
  public static final int maxFirstClassSeats = 12;
  public static final int maxBusinessClassSeats = 52;
  public static final int maxEconomyPlusClassSeats = 88;
  public static final int maxEconomyClassSeats = 222;
  private List<Passenger> passengerList;

  public Airplane() {
    passengerList = CreatePassengerList();
  }

  private List<Passenger> CreatePassengerList() {
    return new ArrayList<>(Arrays.asList(
    new Passenger("Bob", "Smith", 45, Passenger.Seats.A1, Passenger.SeatClass.FirstClass),
    new Passenger("Jane", "Johnson", 25, Passenger.Seats.A2, Passenger.SeatClass.FirstClass),
    new Passenger("Luke", "Williams", 31, Passenger.Seats.A4, Passenger.SeatClass.FirstClass),
    new Passenger("David", "Brown", 29, Passenger.Seats.C3, Passenger.SeatClass.FirstClass),
    new Passenger("Alina", "Volkov", 19, Passenger.Seats.H4, Passenger.SeatClass.FirstClass),
    new Passenger("John", "Carter", 50, Passenger.Seats.K1, Passenger.SeatClass.FirstClass),
    new Passenger("Robert", "Morozov", 44, Passenger.Seats.K3, Passenger.SeatClass.FirstClass),
    new Passenger("Eric", "Harris", 21, Passenger.Seats.A6, Passenger.SeatClass.Business),
    new Passenger("Amy", "Harris", 20, Passenger.Seats.B6, Passenger.SeatClass.Business),
    new Passenger("Jacob", "Agapov", 60, Passenger.Seats.D6, Passenger.SeatClass.Business),
    new Passenger("Inessa", "Young", 33, Passenger.Seats.H6, Passenger.SeatClass.Business),
    new Passenger("Christine", "Green", 41, Passenger.Seats.J6, Passenger.SeatClass.Business),
    new Passenger("Emma", "Garcia", 35, Passenger.Seats.K7, Passenger.SeatClass.Business),
    new Passenger("David", "Smith", 39, Passenger.Seats.H7, Passenger.SeatClass.Business),
    new Passenger("Diane", "Smith", 43, Passenger.Seats.C7, Passenger.SeatClass.Business),
    new Passenger("Tatiana", "Lebedev", 37, Passenger.Seats.A7, Passenger.SeatClass.Business),
    new Passenger("Ivan", "Volkov", 24, Passenger.Seats.C8, Passenger.SeatClass.Business),
    new Passenger("Alex", "Davis", 54, Passenger.Seats.K8, Passenger.SeatClass.Business),
    new Passenger("Jane", "Doe", 26, Passenger.Seats.K9, Passenger.SeatClass.Business),
    new Passenger("Samuel", "Anderson", 65, Passenger.Seats.J10, Passenger.SeatClass.Business),
    new Passenger("John", "Moore", 19, Passenger.Seats.A10, Passenger.SeatClass.Business),
    //
    new Passenger("Denis", "Golubev", 14, Passenger.Seats.A19, Passenger.SeatClass.EconomyPlus),
    new Passenger("Sergey", "Golubev", 35, Passenger.Seats.B19, Passenger.SeatClass.EconomyPlus),
    new Passenger("Natalia", "Golubev", 36, Passenger.Seats.C19, Passenger.SeatClass.EconomyPlus),
    new Passenger("Jason", "Lee", 46, Passenger.Seats.E19, Passenger.SeatClass.EconomyPlus),
    new Passenger("Christine", "White", 27, Passenger.Seats.K19, Passenger.SeatClass.EconomyPlus),
    new Passenger("Nicole", "Clark", 61, Passenger.Seats.B21, Passenger.SeatClass.EconomyPlus),
    new Passenger("Kelly", "Clark", 12, Passenger.Seats.D21, Passenger.SeatClass.EconomyPlus),
    new Passenger("Boris", "Antonov", 37, Passenger.Seats.E21, Passenger.SeatClass.EconomyPlus),
    new Passenger("Anatoly", "Pasternak", 42, Passenger.Seats.J21, Passenger.SeatClass.EconomyPlus),
    new Passenger("Frank", "Robinson", 56, Passenger.Seats.E22, Passenger.SeatClass.EconomyPlus),
    new Passenger("Alice", "Smith", 20, Passenger.Seats.K22, Passenger.SeatClass.EconomyPlus),
    new Passenger("Alexander", "Walker", 43, Passenger.Seats.B24, Passenger.SeatClass.EconomyPlus),
    new Passenger("Dylan", "Wright", 21, Passenger.Seats.F24, Passenger.SeatClass.EconomyPlus),
    new Passenger("Ann", "Scott", 33, Passenger.Seats.K25, Passenger.SeatClass.EconomyPlus),
    //
    new Passenger("Mary", "O'Neil", 35, Passenger.Seats.B36, Passenger.SeatClass.Economy),
    new Passenger("Susan", "Davis", 40, Passenger.Seats.A37, Passenger.SeatClass.Economy),
    new Passenger("William", "Martinez", 21, Passenger.Seats.D34, Passenger.SeatClass.Economy),
    new Passenger("Jessica", "Smith", 23, Passenger.Seats.F37, Passenger.SeatClass.Economy),
    new Passenger("Barbara", "Gordon", 34, Passenger.Seats.J36, Passenger.SeatClass.Economy),
    new Passenger("Thomas", "Wilson", 26, Passenger.Seats.K39, Passenger.SeatClass.Economy),
    new Passenger("Daniel", "Jackson", 32, Passenger.Seats.E38, Passenger.SeatClass.Economy),
    new Passenger("Lydia", "Semenov", 50, Passenger.Seats.A41, Passenger.SeatClass.Economy),
    new Passenger("Donald", "Semenov", 49, Passenger.Seats.B41, Passenger.SeatClass.Economy)
    ));
  }

  public List<Passenger> GetPassengerList(Function<List<Passenger>, List<Passenger>> f) {return f.apply(passengerList);}
  public long GetPassengerStatistics(Function<List<Passenger>, Long> f) {return f.apply(passengerList);}
  public List<Passenger.Seats> GetAvailableSeats(
    Function<List<Passenger>, ArrayList<Passenger.Seats>> passengerSeats,
    BiFunction<List<Passenger.Seats>, ArrayList<Passenger.Seats>, List<Passenger.Seats>> filterSeats
  ) {
    return filterSeats.apply(new ArrayList<>(EnumSet.allOf(Passenger.Seats.class)), passengerSeats.apply(passengerList));
  }
}
