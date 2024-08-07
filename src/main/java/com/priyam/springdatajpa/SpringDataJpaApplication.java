package com.priyam.springdatajpa;

import com.priyam.springdatajpa.model.Game;
import com.priyam.springdatajpa.repository.GameRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;


@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		GameRepo gameRepo = context.getBean(GameRepo.class);

		Game game1 = context.getBean(Game.class);
		Game game2 = context.getBean(Game.class);
		Game game3 = context.getBean(Game.class);

		game1.setTag(1);
		game1.setTitle("AC Mirage");
		game1.setRating(9.1);

		game2.setTag(2);
		game2.setTitle("Black Adam");
		game2.setRating(10.0);

		game3.setTag(3);
		game3.setTitle("AC Origin");
		game3.setRating(8.2);

		gameRepo.save(game1);
		gameRepo.save(game2);
		gameRepo.save(game3);

		System.out.println(gameRepo.count());		//count of total number of data

		System.out.println(gameRepo.findAll());		//fetch all data

		System.out.println(gameRepo.findById(3));	//fetch by primary key @Id , but can give null point exception if id is not in DB
//		---
//		OR
//		---
		Optional<Game> g = gameRepo.findById(6);	//to avoid null point exception
		System.out.println(g.orElse(new Game()));	//returning a new object having null values instead of getting null pointer exception

		System.out.println(gameRepo.findByTitle("Black Adam"));		//returns a list
		System.out.println(gameRepo.findByRatingGreaterThan(9.0));
		System.out.println(gameRepo.findByRating(9));
	}

}
