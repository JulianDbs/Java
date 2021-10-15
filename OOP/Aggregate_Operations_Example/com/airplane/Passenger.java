package com.airplane;

public class Passenger {
  public static enum SeatClass {FirstClass, Business, EconomyPlus, Economy};
  public static enum Seats {
    //First Class.
    A1, A2, A3, A4, C3, C4, H3, H4, K1, K2, K3, K4,
    //Business Class.
    A6, A7, A8, A9, A10, A13, A14, A15, A16, B6, B7, B8, B9, B10, B13, B14, B15,
    B16, C6, C7, C8, D6, D7, D8, G6, G7, G8, H6, H7, H8, J6, J7, J8, J9, J10, J12,
    J13, J14, J15, J16, J17, K6, K7, K8, K9, K10, K12, K13, K14, K15, K16, K17,
    //Economy Plus Class.
    A19, A20, A21, A22, A23, A24, A25, B19, B20, B21, B22, B23, B24, B25, C19,
    C20, C21, C22, C23, C24, C25, D19, D20, D21, D22, D23, D24, D25, E19, E20,
    E21, E22, E23, E24, E25, F19, F20, F21, F22, F23, F24, F25, G19, G20, G21,
    G22, G23, G24, G25, H19, H20, H21, H22, H23, H24, H25, J19, J20, J21, J22,
    J23, J24, J25, K19, K20, K21, K22, K23, K24, K25, B33, C33, D34, E34, F34,
    G34, A45, B45, C45, D49, E49, F49, G49, H45, J45, K45,
    //Economy Class.
    A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, B34, B35, B36, B37,
    B38, B39, B40, B41, B42, B43, C34, C35, C36, C37, C38, C39, C40, C41, C42,
    C43, D35, D36, D37, D38, D39, D40, D41, E35, E36, E37, E38, E39, E40, E41,
    F35, F36, F37, F38, F39, F40, F41, G35, G36, G37, G38, G39, G40, G41, H33,
    H34, H35, H36, H37, H38, H39, H40, H41, H42, H43, J33, J34, J35, J36, J37,
    J38, J39, J40, J41, J42, J43, K33, K34, K35, K36, K37, K38, K39, K40, K41,
    K42, K43, A46, A47, A48, A49, A50, A51, A52, A53, A54, A55, A56, A57, B46,
    B47, B48, B49, B50, B51, B52, B53, B54, B55, B56, B57, B58, B59, B60, B61,
    C46, C47, C48, C49, C50, C51, C52, C53, C54, C55, C56, C57, C58, C59, C60,
    C61, D50, D51, D52, D53, D54, D55, D56, D57, D58, D59, D60, D61, E50, E51,
    E52, E53, E54, E55, E56, E57, E58, E59, E60, E61, F50, F51, F52, F53, F54,
    F55, F56, F57, F58, F59, F60, F61, G50, G51, G52, G53, G54, G55, G56, G57,
    G58, G59, G60, G61, H46, H47, H48, H49, H50, H51, H52, H53, H54, H55, H56,
    H57, H58, H59, H60, H61, J46, J47, J48, J49, J50, J51, J52, J53, J54, J55,
    J56, J57, J58, J59, J60, J61, K46, K47, K48, K49, K50, K51, K52, K53, K54,
    K55, K56, K57
  }

  public String FirstName;
  public String LastName;
  public int Age;
  public Seats Seat;
  public SeatClass seatClass;

  public Passenger(
    String FirstName,
    String LastName,
    int Age,
    Seats Seat,
    SeatClass seatClass
    ) {
    this.FirstName = FirstName;
    this.LastName = LastName;
    this.Age = Age;
    this.Seat = Seat;
    this.seatClass = seatClass;
  }
}
