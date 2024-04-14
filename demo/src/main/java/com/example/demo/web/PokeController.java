package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.PokeRepository;

@Controller
public class PokeController {

    @Autowired
    private PokeRepository repository;

    @RequestMapping("/pokemonlist")
    public String pokemonList(Model model) {
        model.addAttribute("pokemons", repository.findAll());
        return "pokemonlist"; // This should be the name of your Thymeleaf template file
    }
}
