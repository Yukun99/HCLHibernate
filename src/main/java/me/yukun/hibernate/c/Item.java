package me.yukun.hibernate.c;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "item")
@Entity
public class Item implements Comparable<Item> {

  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "category")
  private String category;
  @Column(name = "\"number\"")
  private Integer number;
  @Column(name = "price")
  private Float price;

  public Item() {
  }

  public Item(int id, String name, String category, int number, float price) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.number = number;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Item [id=" + id + ", name=" + name + ", category=" + category + ", number=" + number
        + ", price=" + price + "]";
  }

  @Override
  public int compareTo(Item o) {
    return 0;
  }
}
