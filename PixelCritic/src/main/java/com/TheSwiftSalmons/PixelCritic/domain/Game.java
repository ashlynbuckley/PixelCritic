//22404136 Szymon Fijalkowski
package com.TheSwiftSalmons.PixelCritic.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long gameId;
	
	private String name, tag, platform;
	private int releaseYear, price;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
	private List<Review> reviews;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "developerId")
	private Developer developer;
	
	public Game() {
		super();
	}
	
	public Game(String name, String tag, String platform, int releaseYear, int price, Developer developer) {
		this.setName(name);
		this.setTag(tag);
		this.setPlatform(platform);
		this.setReleaseYear(releaseYear);
		this.setPrice(price);
		this.setDeveloper(developer);
	}
	
	//getters and setters
	public Developer getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Long getId() {
		return gameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public List<Review> getReviews()
	{
		return reviews;
	}

	public void setReviews(List<Review> reviews)
	{
		this.reviews = reviews;
	}
}
