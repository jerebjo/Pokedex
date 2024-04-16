package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CaptureDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private int pokeballsUsed;

    @ManyToOne
    private Pokemon pokemon;

    public CaptureDetails() {
    }

    public CaptureDetails(Long pokemonId, String location, int pokeballsUsed) {
        this.location = location;
        this.pokeballsUsed = pokeballsUsed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPokeballsUsed() {
        return pokeballsUsed;
    }

    public void setPokeballsUsed(int pokeballsUsed) {
        this.pokeballsUsed = pokeballsUsed;
    }
}
