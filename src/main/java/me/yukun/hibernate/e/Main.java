package me.yukun.hibernate.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws NumberFormatException, IOException, ParseException {

    Logger log = Logger.getLogger("org.hibernate");
    log.setLevel(Level.OFF);
    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    ItemBO itemBO = new ItemBO();
    do {
      System.out.println("Menu");
      System.out.println("1.Update item price");
      System.out.println("2.Delete item");
      System.out.println("3.Display items");
      System.out.println("4.Exit");
      System.out.println("Enter choice");
      switch (Integer.parseInt(br.readLine())) {
        case 1:
          System.out.println("Enter item id");
          int id = Integer.parseInt(br.readLine());
          Item updated = itemBO.findItemById(id);
          if (updated == null) {
            System.out.println("Item not found");
            break;
          }
          System.out.println("Enter new price");
          float price = Float.parseFloat(br.readLine());
          updated.setPrice(price);
          itemBO.updateItemPriceById(updated);
          break;
        case 2:
          System.out.println("Enter item id");
          int id2 = Integer.parseInt(br.readLine());
          Item deleted = itemBO.findItemById(id2);
          if (deleted == null) {
            System.out.println("Item not found");
            break;
          }
          itemBO.deleteItem(deleted);
          break;
        case 3:
          List<Item> itemList = itemBO.listItems();
          System.out.println("Item Details");
          if (itemList.isEmpty()) {
            System.out.println("Empty list");
            System.exit(0);
          }
          System.out.printf("%-15s %-15s %-15s %-15s %s\n", "Id", "Name", "Category", "Number",
              "Price");
          for (Item i : itemList) {
            System.out.println(i);
          }
          break;
        case 4:
          System.exit(0);
        default:
          System.out.println("Invalid choice");
      }
    } while (true);
  }
}
