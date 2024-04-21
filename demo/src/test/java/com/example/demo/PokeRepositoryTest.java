package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.PokeRepository;
import com.example.demo.model.Pokemon;
import com.example.demo.model.PokemonType;
import com.example.demo.model.PokemonTypeRepository;

@DataJpaTest
public class PokeRepositoryTest {

    @Autowired
    private PokeRepository pokeRepository;

    @Autowired
    private PokemonTypeRepository pTypeRepository;

    @Test
    public void testPokeRepository() {
        PokemonType electricType = new PokemonType("Electric");
        pTypeRepository.save(electricType);

        Pokemon pokemon = new Pokemon("Pikachu", electricType, "20kg", "70cm", "male", 729);
        pokeRepository.save(pokemon);

        java.util.Optional<Pokemon> foundPokemon = pokeRepository.findById(pokemon.getId());
        assertThat(foundPokemon).isPresent();

        pokeRepository.delete(pokemon);
        assertThat(pokeRepository.findById(pokemon.getId())).isEmpty();
    }

    @Test
    public void testPokemonTypeRepository() {
        PokemonType pokemonType = new PokemonType("test");
        pTypeRepository.save(pokemonType);

        // Etsi Pokemon-tyyppi nimen perusteella
        Optional<PokemonType> foundPokemonTypeOptional = pTypeRepository.findByName("test");

        // Tarkista, että Pokemon-tyyppi löytyi
        assertThat(foundPokemonTypeOptional).isPresent();

        // Jos Pokemon-tyyppi löytyi, tarkista sen tiedot
        foundPokemonTypeOptional.ifPresent(foundPokemonType -> {
            System.out.println("Found Pokemon type: " + foundPokemonType.getName());
            // Voit lisätä muita tarkistuksia tarpeen mukaan
        });

        // Voit lisätä muita odotuksia tai tarkistuksia löydetyille Pokemon-tyypeille
        // tarpeen mukaan
    }

}
