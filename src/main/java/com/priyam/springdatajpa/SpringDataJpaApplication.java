package com.priyam.springdatajpa;

import com.priyam.springdatajpa.model.Game;
import com.priyam.springdatajpa.repository.GameRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
		game2.setTitle("PUBG");
		game2.setRating(10.0);

		game3.setTag(3);
		game3.setTitle("AC Origin");
		game3.setRating(8.2);

		gameRepo.save(game1);
		gameRepo.save(game2);
		gameRepo.save(game3);

	}

}
