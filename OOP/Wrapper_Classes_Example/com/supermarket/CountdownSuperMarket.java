package com.supermarket;

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;
import com.supermarket.products.Product;

public class CountdownSuperMarket {
  private DecimalFormat priceFormatter = new DecimalFormat("$######.00");
  private DecimalFormat roundingFormatter = new DecimalFormat("$0.00");
  private List<Product> productList = new ArrayList<>();
  private String emptyLine = "|\t\t\t\t\t\t\t|%n";

  public void addProductToList(Product product) {productList.add(product);}

  public String getTicket() {
    StringBuilder ticket = new StringBuilder(emptyLine);
    ticket.append("|\t\t\tCOUNTDOWN\t\t\t|%n");
    ticket.append("|\t\t\tshop smarter\t\t\t|%n");
    ticket.append(emptyLine);
    ticket.append("|\tA division of General Distributors Ltf\t\t|%n");
    ticket.append("|\t\tGREENLANE\t PH 2552381\t\t|%n");
    ticket.append("|\t\t326 GREAT SOUTH ROAD GREENLANE\t\t|%n");
    ticket.append("|\tTax Invoice\t\tGST No. 44-833-938\t|%n");
    ticket.append(emptyLine);
    for (int i = 0; i<productList.size(); i++) {
      ticket.append("|\t");
      ticket.append(getProductInfo(i));
      ticket.append("\t|\n");
    }
    ticket.append("|\t");
    ticket.append(productList.size() + "\tSUBTOTAL\t\t\t");
    String originalPrice = priceFormatter.format(getTotalPrice());
    ticket.append(originalPrice + "\t|%n");
    ticket.append(emptyLine);
    if (priceEndsWithZero(originalPrice)) {
      ticket.append("|\tTOTAL\t\t\t\t\t" + originalPrice + "\t|%n");
    } else {
      Double roundPrice = roundPrice(Double.valueOf(getTotalPrice()));
      Double roundig = (roundPrice - getTotalPrice());
      ticket.append("|\tROUNDING\t\t\t\t" + roundingFormatter.format(roundig) + "\t|%n");
      ticket.append("|\tTOTAL\t\t\t\t\t" + priceFormatter.format(roundPrice) + "\t|%n");
    }
    ticket.append(emptyLine);
    return ticket.toString();
  }

  private boolean priceEndsWithZero(String price) {
    Character lastCharacter = Character.valueOf(price.charAt(price.length() -1));
    return lastCharacter.equals((char)48);
  }

  private String getProductInfo(Integer index) {
    String productName = productList.get(index).getProductName();
    StringBuilder stringBuilder = new StringBuilder(productName);
    stringBuilder.append(getTabs(productName.length()));
    stringBuilder.append(
      priceFormatter.format(productList.get(index).getProductPrice())
    );
    return stringBuilder.toString();
  }

  private String getTabs(Integer nameLength) {
    String tabs = "";
    for (int i = 0; i < 41; i = i + 4) {
      if (nameLength > (i - 4) && nameLength < (i+1)) {
        Integer count = i / 4;
        switch(count) {
          case 1: case 2: case 3: tabs = "\t\t\t\t"; break;
          case 4: case 5: tabs = "\t\t\t"; break;
          case 6: case 7: case 8: tabs = "\t\t"; break;
          case 9: case 10: tabs = "\t"; break;
        }
        break;
      }
    }
    return tabs;
  }

  private Double getTotalPrice() {
    double totalPrice = 0;
    for (Product product:productList) {
      totalPrice += product.getProductPrice();
    }
    String[] split = String.valueOf(totalPrice).split("\\.");
    Double clearPrice;
    if (split[1].length() >= 3) {
      String substring = String.valueOf(split[1].charAt(0)) + String.valueOf(split[1].charAt(1));
      clearPrice = Double.valueOf(split[0].concat(".").concat(substring));
    } else {
      clearPrice = Double.valueOf(totalPrice);
    }
    return clearPrice;
  }

  private Double roundPrice(Double price) {
      String[] split = String.valueOf(price).split("\\.");
      int firstDigit = Integer.valueOf(String.valueOf(split[1].charAt(0)));
      int lastDigit = Integer.valueOf(String.valueOf(split[1].charAt(1)));
      if (lastDigit > 5) {
        firstDigit +=1; lastDigit = 0;
      } else {
        lastDigit = 0;
      }
      return Double.valueOf(split[0] + "." + String.valueOf(firstDigit) + String.valueOf(lastDigit));
  }
}
