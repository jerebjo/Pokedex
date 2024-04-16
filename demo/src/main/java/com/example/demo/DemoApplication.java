package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.PokeRepository;
import com.example.demo.model.Pokemon;
import com.example.demo.model.PokemonType;
import com.example.demo.model.PokemonTypeRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PokeRepository repository, PokemonTypeRepository typeRepository) {
		return (args) -> {
			// Luo ja tallenna PokemonType-oliot
			PokemonType electric = new PokemonType("Electric");
			typeRepository.save(electric);

			PokemonType water = new PokemonType("Water");
			typeRepository.save(water);

			PokemonType ground = new PokemonType("Ground");
			typeRepository.save(ground);

			PokemonType rock = new PokemonType("Rock");
			typeRepository.save(rock);

			PokemonType fairy = new PokemonType("Fairy");
			typeRepository.save(fairy);

			PokemonType dark = new PokemonType("Dark");
			typeRepository.save(dark);

			PokemonType fire = new PokemonType("Fire");
			typeRepository.save(fire);

			PokemonType grass = new PokemonType("Grass");
			typeRepository.save(grass);

			PokemonType psychic = new PokemonType("Phychic");
			typeRepository.save(psychic);

			PokemonType steel = new PokemonType("Steel");
			typeRepository.save(steel);

			PokemonType fighting = new PokemonType("Fighting");
			typeRepository.save(fighting);

			PokemonType normal = new PokemonType("Normal");
			typeRepository.save(normal);

			PokemonType ice = new PokemonType("Ice");
			typeRepository.save(ice);

			PokemonType bug = new PokemonType("Bug");
			typeRepository.save(bug);

			PokemonType ghost = new PokemonType("Ghost");
			typeRepository.save(ghost);

			PokemonType dragon = new PokemonType("Dragon");
			typeRepository.save(dragon);

			PokemonType flying = new PokemonType("Flying");
			typeRepository.save(flying);

			PokemonType poison = new PokemonType("Poison");
			typeRepository.save(poison);

			// Luodaan Pokemon-oliot käyttäen tallennettuja PokemonType-olioita
			Pokemon p1 = new Pokemon("Pikachu", electric, "20kg", "70cm", "male", 729);
			Pokemon p2 = new Pokemon("Totodile", water, "25kg", "75cm", "male", 832);

			// Tallennetaan Pokemon-oliot tietokantaan
			repository.save(p1);
			repository.save(p2);
		};
	}
}
