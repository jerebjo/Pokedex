package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.PokeRepository;
import com.example.demo.model.Pokemon;

@Controller
public class PokeController {

    @Autowired
    private PokeRepository repository;

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

    @RequestMapping(value = "/add")
    public String addPokemon(Model model) {
        model.addAttribute("pokemon", new Pokemon());
        return "addpokemon";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Pokemon pokemon) {
        repository.save(pokemon);
        return "redirect:pokemonlist";
    }
}
