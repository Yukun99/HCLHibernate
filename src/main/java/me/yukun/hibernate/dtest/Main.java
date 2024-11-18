package me.yukun.hibernate.dtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws NumberFormatException, IOException {
    System.out.println("Enter no. of advertisements done :");
    int n = Integer.parseInt(br.readLine());
    AdvertisementDAO dao = new AdvertisementDAO();
    for (int i = 0; i < n; i++) {
      String[] data = br.readLine().split(",");
      String name = data[0];
      double price = Double.parseDouble(data[1]);
      int audience = Integer.parseInt(data[2]);
      Advertisement ad = new Advertisement(name, price, audience);
      dao.insert(ad);
    }
    System.out.println("Advertisement details");
    System.out.printf("%-5s %-20s %-15s %s\n", "Id", "Advertisement media", "Amount spent",
        "No Of audience attracted");
    for (Advertisement ad : dao.list()) {
      System.out.println(ad);
    }
    System.out.println("Enter advertisement id :");
    Advertisement found = dao.find(Integer.parseInt(br.readLine()));
    if (found == null) {
      System.out.println("Advertisement not found!");
          return;
    }
    System.out.println("Enter no of new users attracted :");
    found.setAudience(found.getAudience() + Integer.parseInt(br.readLine()));
    dao.update(found);
    System.out.println("Advertisement details");
    System.out.printf("%-5s %-20s %-15s %s\n", "Id", "Advertisement media", "Amount spent",
        "No Of audience attracted");
    for (Advertisement ad : dao.list()) {
      System.out.println(ad);
    }
  }
}
