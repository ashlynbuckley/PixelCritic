package com.TheSwiftSalmons.PixelCritic.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheSwiftSalmons.PixelCritic.domain.Developer;
import com.TheSwiftSalmons.PixelCritic.domain.DeveloperRepository;
import com.TheSwiftSalmons.PixelCritic.domain.Game;
import com.TheSwiftSalmons.PixelCritic.domain.GameRepository;
import com.TheSwiftSalmons.PixelCritic.domain.Review;
import com.TheSwiftSalmons.PixelCritic.domain.ReviewRepository;
import com.TheSwiftSalmons.PixelCritic.domain.User;
import com.TheSwiftSalmons.PixelCritic.domain.UserRepository;

@RestController
public class PixelCriticController
{
	
	private final GameRepository repository;
	private final ReviewRepository rerepository;
	private final DeveloperRepository devrepository;
	private final UserRepository urepository;

	public PixelCriticController(GameRepository repository, ReviewRepository rerepository, DeveloperRepository devrepository, UserRepository urepository)
	{
		this.repository = repository;
		this.rerepository = rerepository;
		this.devrepository = devrepository;
		this.urepository = urepository;
	}

	@GetMapping("/games")
	public Iterable<Game> getGames()
	{
		return repository.findAll();
	}
	
	@GetMapping("/reviews")
	public Iterable<Review> getReviews()
	{
		return rerepository.findAll();
	}
	
	@GetMapping("/developers")
	public Iterable<Developer> getDevelopers()
	{
		return devrepository.findAll();
	}
	
	@GetMapping("/users")
	public Iterable<User> getUser()
	{
		return urepository.findAll();
	}
}
