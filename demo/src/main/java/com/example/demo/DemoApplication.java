package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.PokeRepository;
import com.example.demo.model.Pokemon;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PokeRepository repository) {
		return (args) -> {
			Pokemon p1 = new Pokemon("Pikachu", "electric", "20kg", "70cm", "male", 729);
			Pokemon p2 = new Pokemon("Totodile", "water", "25kg", "75cm", "male", 832);

			repository.save(p1);
			repository.save(p2);
		};
	}
}
