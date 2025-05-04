package com.snakeladder.snakeladder;

import Controller.Game;
import models.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnakeladderApplication {

	public static void main(String[] args) {

		SpringApplication.run(SnakeladderApplication.class, args);
		System.out.println("Hello, Welcome to Snake Ladder Game!⭐⭐⭐⭐⭐");
		Game game = new Game(100, 10, 10, 1);
		game.addPlayer(new Player("Alice"));
		game.addPlayer(new Player("Bob"));
		game.addPlayer(new Player("Charlie"));
		game.startGame();
	}
}
