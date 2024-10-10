//Ashlyn
package com.TheSwiftSalmons.PixelCritic.domain;

import java.util.Set;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id //primary key field
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reviewId; 
	
	private String content;
	private int rating;

	//review has one author; author(User) has many reviews
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId") //how we connect to User table
	private User author;

	//@ManyToMany
	//@JoinTable(
	//name = "hasTags", //name of join table
	//create fks
	//joinColumns = @JoinColumn(name = "reviewId") ,
	//inverseJoinColumns = @JoinColumn(name = "tagId")
	//)
	//private Set<Tag> tags;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gameId")
	private Game game;


	//constructors
	public Review() {
		super();
	}

	public Review(Game game, User author, int rating, String content) {
		
		this.game = game;
		this.author = author;
		this.content = content;//can be null
		this.rating = rating;
		//will have tags with a join table
	}

	//getter
	public Long getReviewId() {
		return reviewId;
	}

	public Game getGame() {
		return game;
	}

	public User getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public int getRating() {
		return rating;
	}

	//setters
	public void setGame(Game game) {
		this.game = game;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
