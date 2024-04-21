package com.example.demo.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PokemonTypeRepository extends CrudRepository<PokemonType, Long> {

    Optional<PokemonType> findByName(String name);
}
