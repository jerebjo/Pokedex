package com.example.demo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.PokeRepository;
import com.example.demo.model.Pokemon;
import com.example.demo.model.PokemonTypeRepository;

@Controller
public class PokeController {

    @Autowired
    private PokeRepository repository;

    @Autowired
    private PokemonTypeRepository PokemonTypeRepository;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = { "/", "/pokemonlist" })
    public String pokemonList(Model model) {
        model.addAttribute("pokemons", repository.findAll());
        return "pokemonlist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePokemon(@PathVariable Long id, Model model) {
        repository.deleteById(id);
        return "redirect:../pokemonlist";
    }

    @RequestMapping(value = "/addpokemon")
    public String addPokemon(Model model) {
        model.addAttribute("pokemon", new Pokemon());
        model.addAttribute("types", PokemonTypeRepository.findAll());
        return "addpokemon";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Pokemon pokemon) {
        repository.save(pokemon);
        return "redirect:pokemonlist";
    }

    @GetMapping("/evolve/{id}")
    public String showEvolvePokemonForm(@PathVariable Long id, Model model) {
        Optional<Pokemon> pokemon = repository.findById(id);
        model.addAttribute("pokemon", pokemon.orElse(new Pokemon()));
        model.addAttribute("types", PokemonTypeRepository.findAll());
        return "evolvepokemon";
    }

    @PostMapping("/evolve")
    public String evolvePokemon(@ModelAttribute Pokemon pokemon) {
        repository.save(pokemon); // Tallennetaan päivitetty Pokémon
        return "redirect:/pokemonlist"; // Ohjataan takaisin Pokemon-listauksen sivulle
    }

}
