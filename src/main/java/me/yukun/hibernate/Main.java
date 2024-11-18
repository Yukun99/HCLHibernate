package me.yukun.hibernate;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    ProductDAO dao = new ProductDAO();
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter product ID:");
    int id = Integer.parseInt(sc.nextLine());
    System.out.println("Enter product name:");
    String name = sc.nextLine();
    System.out.println("Enter product price:");
    double price = Double.parseDouble(sc.nextLine());
    Product product = new Product(id, name, price);

    System.out.println("Inserting data into DB...");
    dao.addProduct(product);
    System.out.println("Product inserted into DB.");
  }
}
