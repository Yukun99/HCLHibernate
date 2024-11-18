package me.yukun.hibernate.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws NumberFormatException, IOException {
    ItemDAO dao = new ItemDAO();
    do {
      System.out.println(
          "Menu\n1.Add item\n2.Change item\n3.Remove item\n4.Display items\n5.Exit\nEnter choice");
      switch (Integer.parseInt(br.readLine())) {
        case 1:
          System.out.println("Enter item id");
          int id = Integer.parseInt(br.readLine());
          System.out.println("Enter name");
          String name = br.readLine();
          System.out.println("Enter category");
          String category = br.readLine();
          System.out.println("Enter number");
          int number = Integer.parseInt(br.readLine());
          System.out.println("Enter price");
          float price = Float.parseFloat(br.readLine());
          Item item = new Item(id, name, category, number, price);
          dao.insert(item);
          System.out.println("Added to the list successfully");
          break;
        case 2:
          System.out.println("Enter item id");
          int id2 = Integer.parseInt(br.readLine());
          Item item2 = dao.find(id2);
          if (item2 == null) {
            System.out.println("Item not found");
          } else {
            System.out.println("Enter name");
            String name2 = br.readLine();
            System.out.println("Enter category");
            String category2 = br.readLine();
            System.out.println("Enter number");
            int number2 = Integer.parseInt(br.readLine());
            System.out.println("Enter price");
            float price2 = Float.parseFloat(br.readLine());
            System.out.println("Changes are updated successfully");
            item2 = new Item(id2, name2, category2, number2, price2);
            dao.update(item2);
          }
          break;
        case 3:
          System.out.println("Enter item id");
          int id3 = Integer.parseInt(br.readLine());
          dao.remove(id3);
          System.out.println("Item was Deleted");
          break;
        case 4:
          List<Item> itemList = dao.list();
          if (itemList.isEmpty()) {
            System.out.println("Empty list");
          } else {
            System.out.printf("%-15s %-15s %-15s %-15s %s\n", "Id", "Name", "Category", "Number",
                "Price");
            for (Item i : itemList) {
              System.out.printf("%-15s %-15s %-15s %-15s %s\n", i.getId(), i.getName(),
                  i.getCategory(), i.getNumber(), i.getPrice());
            }
          }
          break;
        case 5:
          System.out.println("Bye");
          System.exit(0);
        default:
          System.out.println("Invalid choice");
      }
    } while (true);
  }
}
