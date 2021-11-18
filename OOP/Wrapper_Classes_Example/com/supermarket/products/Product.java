package com.supermarket.products;

public class Product {
  private String productName;
  private double productPrice;
  private String productLabel;
  private String productDescription;

  public Product(
    String productName, double productPrice,
    String productLabel, String productDescription
    ) {
    this.productName = productName;
    this.productPrice = productPrice;
    this.productLabel = productLabel;
    this.productDescription = productDescription;
  }


  public Double getProductPrice() {return this.productPrice;}

  public String getProductName() {return this.productName;}

  public String getProductLabel() {return this.productLabel;}
}
