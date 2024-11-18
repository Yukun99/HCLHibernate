package me.yukun.hibernate.b;

import java.util.Scanner;
import me.yukun.hibernate.a.User;
import me.yukun.hibernate.a.UserDAO;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Menu");
    System.out.println("1.Sign up");
    System.out.println("2.Login");
    System.out.println("3.Exit");
    System.out.println("Enter choice");
    int choice = Integer.parseInt(sc.nextLine());
    UserDAO userDAO = new UserDAO();
    while (choice != 3) {
      switch (choice) {
        case 1:
          System.out.println("Enter name");
          String name = sc.nextLine();
          System.out.println("Enter phone number");
          long phoneNumber = Long.parseLong(sc.nextLine());
          System.out.println("Enter user id");
          String userId = sc.nextLine();
          System.out.println("Enter password");
          String password = sc.nextLine();
          User user = new User(userId, name, phoneNumber, password);
          userDAO.insert(user);
          System.out.println("Menu");
          System.out.println("1.Sign up");
          System.out.println("2.Login");
          System.out.println("3.Exit");
          System.out.println("Enter choice");
          choice = Integer.parseInt(sc.nextLine());
          break;
        case 2:
          System.out.println("Enter user id");
          String userId2 = sc.nextLine();
          User found = userDAO.find(userId2);
          if (found == null) {
            System.out.println("No such user. Please sign up before login.");
            System.out.println("Menu");
            System.out.println("1.Sign up");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            System.out.println("Enter choice");
            choice = Integer.parseInt(sc.nextLine());
            break;
          }
          System.out.println("Enter password");
          String password2 = sc.nextLine();
          if (found.getPassword().equals(password2)) {
            System.out.printf(
                "Welcome %s. This is secret only accessible to the authenticated user\n",
                found.getName());
          } else {
            System.out.println("Wrong password. Please try again");
          }
          System.out.println("Menu");
          System.out.println("1.Sign up");
          System.out.println("2.Login");
          System.out.println("3.Exit");
          System.out.println("Enter choice");
          choice = Integer.parseInt(sc.nextLine());
          break;
        default:
          System.out.println("Invalid choice");
          System.out.println("Menu");
          System.out.println("1.Sign up");
          System.out.println("2.Login");
          System.out.println("3.Exit");
          System.out.println("Enter choice");
          choice = Integer.parseInt(sc.nextLine());
      }
    }
    System.out.println("Bye");
  }
}
