//Avalon
package com.TheSwiftSalmons.PixelCritic.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Developer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "developerId", nullable = false)
    private Long developerId; // Primary key

    private String developerName, address;
    
    public Developer() {
		super();
	}
	
	public Developer(String developerName, String address) {
		this.setDeveloperName(developerName);
		this.setAddress(address);
	}
	
    // One Developer can have many Games
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "developer")
    private List<Game> games;

    // Getters and Setters

    // named getId so that JPA can find it for the game repo query get by developer id
    public Long getId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}

