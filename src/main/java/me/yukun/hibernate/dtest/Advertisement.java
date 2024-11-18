package me.yukun.hibernate.dtest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "advertisement")
@Entity
public class Advertisement {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @Column(name = "advertisementMedia")
  private String media;
  @Column(name = "amountSpent")
  private double cost;
  @Column(name = "noOfAudienceAttracted")
  private int audience;

  public Advertisement() {
  }

  public Advertisement(String media, double cost, int audience) {
    this.media = media;
    this.cost = cost;
    this.audience = audience;
  }

  public Advertisement(int id, String media, double cost, int audience) {
    this.id = id;
    this.media = media;
    this.cost = cost;
    this.audience = audience;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMedia() {
    return media;
  }

  public void setMedia(String media) {
    this.media = media;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public int getAudience() {
    return audience;
  }

  public void setAudience(int audience) {
    this.audience = audience;
  }

  @Override
  public String toString() {
    return String.format("%-5s %-20s %-15s %s", id, media, cost, audience);
  }
}
