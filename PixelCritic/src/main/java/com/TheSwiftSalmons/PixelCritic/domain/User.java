//Conor Salmon
package com.TheSwiftSalmons.PixelCritic.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long authorId;
  
  private String username;
  private String email;
  private String password;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private List<Review> reviews;

  public User() {
	  super();
  }
  public User(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password;
  }

  // Getters and Setters
  public Long getId() {
      return authorId;
  }

  public String getUsername() {
      return username;
  }

  public void setUsername(String username) {
      this.username = username;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getPassword() {
      return password;
  }

  public void setPassword(String password) {
      this.password = password;
  }
  
  public List<Review> getReviews() {
      return reviews;
  }

  public void setGames(List<Review> reviews) {
      this.reviews = reviews;
  }
}
