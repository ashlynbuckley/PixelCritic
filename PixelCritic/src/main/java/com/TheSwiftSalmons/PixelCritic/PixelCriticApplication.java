package com.TheSwiftSalmons.PixelCritic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.TheSwiftSalmons.PixelCritic.domain.GameRepository;
import com.TheSwiftSalmons.PixelCritic.domain.Review;
import com.TheSwiftSalmons.PixelCritic.domain.ReviewRepository;
import com.TheSwiftSalmons.PixelCritic.domain.User;
import com.TheSwiftSalmons.PixelCritic.domain.UserRepository;
import com.TheSwiftSalmons.PixelCritic.domain.Developer;
import com.TheSwiftSalmons.PixelCritic.domain.DeveloperRepository;
import com.TheSwiftSalmons.PixelCritic.domain.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PixelCriticApplication implements CommandLineRunner {
	
	private final GameRepository repository;
	private final ReviewRepository rerepository;
	private final DeveloperRepository devrepository;
	private final UserRepository urepository;
	
	private static final Logger Logger = LoggerFactory.getLogger(PixelCriticApplication.class);
	
	public PixelCriticApplication(GameRepository repository, ReviewRepository rerepository, DeveloperRepository devrepository, UserRepository urepository)
	{
		this.repository = repository;
		this.rerepository = rerepository;
		this.devrepository = devrepository;
		this.urepository = urepository;
	}

	public static void main(String[] args) {
		
		SpringApplication.run(PixelCriticApplication.class, args);
		
		Logger.info("Application started!");
	}
	
	@Override
	public void run(String... args) throws Exception 
	{
		User user1 = new User("TheAlphaMan420","AwesomeBeast@gmail.com","yes");
		User user2 = new User("FloorGang69", "Pewdiepiefan@gmail.com", "no");
		Developer dev1 = new Developer("Nintendo", "Everywhere Idk");
		
		urepository.save(user1);
		urepository.save(user2);
		devrepository.save(dev1);
		
		Game game1 = new Game("Minecraft", "Open World", "PC", 2011, 30, dev1);
		Game game2 = new Game("Undertale", "RPG", "PC", 2015, 10, dev1);
		Game game3 = new Game("Dark Souls", "Difficult", "PlayStation", 2011, 60, dev1);
		
		repository.save(game1);
		repository.save(game2);
		repository.save(game3);
		rerepository.save(new Review(game1, user1, 4, "This game great!"));
		rerepository.save(new Review(game3, user1, 5, "This game really great!"));
		rerepository.save(new Review(game1, user2, 2, "not good!"));
		
		for (Game game : repository.findAll()) 
		{
			Logger.info("Title: {}, Tag: {}, Platform: {}", game.getName(), game.getTag(), game.getPlatform());
		}
	}
}
