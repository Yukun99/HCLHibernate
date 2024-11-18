package me.yukun.hibernate.a;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "\"user\"")
@Entity
public class User implements Comparable<User> {

  @Id
  @Column(name = "userID")
  private String userId;
  @Column(name = "name")
  private String name;
  @Column(name = "password")
  private String password;
  @Column(name = "phoneNumber")
  private Long phoneNumber;

  public User() {
  }

  public User(String userId, String name, long phoneNumber, String password) {
    this.userId = userId;
    this.name = name;
    this.password = password;
    this.phoneNumber = phoneNumber;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String id) {
    this.userId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return String.format("%-15s %-15s %s", name, phoneNumber, userId);
  }

  @Override
  public int compareTo(User o) {
    int nameCompare = name.compareTo(o.name);
    if (nameCompare != 0) {
      return nameCompare;
    }
    return phoneNumber.compareTo(o.phoneNumber);
  }
}
