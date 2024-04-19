package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.PokeRepository;
import com.example.demo.model.Pokemon;
import com.example.demo.model.PokemonType;
import com.example.demo.model.PokemonTypeRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PokeRepository repository, PokemonTypeRepository typeRepository,
			UserRepository userRepository) {
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

			User user1 = new User("user", "$2a$10$kfeF6bvFg3rt5W4/tYl6a.nsCVopvchyEaAstv61y8DpPpV9v8L2O", "USER");
			User user2 = new User("admin", "$2a$10$vze8DfEM89X0zuy1Qfl4TuiT1BOAmzd5v5anTbiOT3jpVFyM0BfW2", "ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);
			// Tallennetaan Pokemon-oliot tietokantaan
			repository.save(p1);
			repository.save(p2);
		};
	}
}
