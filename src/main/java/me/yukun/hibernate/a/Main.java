package me.yukun.hibernate.a;

import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of users");
    int n = Integer.parseInt(sc.nextLine());
    UserDAO dao = new UserDAO();
    for (int i = 1; i <= n; i++) {
      System.out.println("Enter name of user " + i);
      String name = sc.nextLine();
      System.out.println("Enter phone number of user " + i);
      long number = Long.parseLong(sc.nextLine());
      System.out.println("Enter user id of user " + i);
      String id = sc.nextLine();
      System.out.println("Enter password of user " + i);
      String password = sc.nextLine();
      User user = new User(id, name, number, password);
      dao.insert(user);
    }
    sc.close();
    System.out.println("User Details");
    System.out.printf("%-15s %-15s %s\n", "Name", "Phone number", "User id");
    List<User> users = dao.list();
    for (User user : users) {
      System.out.println(user);
    }
  }
}
