// Pokemon.java
package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name, weight, height, gender;
    private int number;
    private String location;
    private int pokeballsUsed; // Lisätään pokeballsUsed-kenttä

    @OneToMany(mappedBy = "pokemon")
    private List<CaptureDetails> captureDetailsList;

    @ManyToOne
    @JoinColumn(name = "typeid")
    private PokemonType type;

    public Pokemon() {
    }

    public Pokemon(String name, PokemonType type, String weight, String height, String gender, int number) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
