package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.CaptureDetails;
import com.example.demo.model.CaptureDetailsRepository;
import com.example.demo.model.Pokemon;
import com.example.demo.model.PokeRepository;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CaptureDetailsController {

    @Autowired
    private PokeRepository pokeRepository;

    @Autowired
    private CaptureDetailsRepository captureDetailsRepository;

    @GetMapping("/pokemonhabitat/{id}")
    public String showCaptureDetailsForm(@PathVariable Long id, Model model) {
        Pokemon pokemon = pokeRepository.findById(id).orElse(null);
        if (pokemon != null) {
            model.addAttribute("pokemon", pokemon);
            return "pokemonhabitat";
        } else {
            return "redirect:/pokemonlist";
        }
    }

    @GetMapping("/editcapture/{id}/edit")
    public String showEditCaptureDetailsForm(@PathVariable Long id, Model model) {
        Pokemon pokemon = pokeRepository.findById(id).orElse(null);
        if (pokemon != null) {
            model.addAttribute("pokemon", pokemon);
            return "editcapture";
        } else {
            return "redirect:/pokemonlist";
        }
    }

    @PostMapping("/editcapture/{id}/edit")
    public String saveCaptureDetails(@PathVariable Long id, @RequestParam String location,
            @RequestParam int pokeballsUsed) {
        Pokemon pokemon = pokeRepository.findById(id).orElse(null);
        if (pokemon != null) {
            CaptureDetails captureDetails = new CaptureDetails(id, location, pokeballsUsed);
            // Tallenna CaptureDetails tietokantaan
            captureDetailsRepository.save(captureDetails);

            System.out.println("Tiedot tallennettu: " + captureDetails);

            // Ohjaa käyttäjä takaisin Pokemon-habitat -sivulle
            return "redirect:/pokemonhabitat/" + id;
        } else {
            return "redirect:/pokemonlist";
        }
    }

}
