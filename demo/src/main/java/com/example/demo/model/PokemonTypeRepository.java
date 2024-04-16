package com.example.demo.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PokemonTypeRepository extends CrudRepository<PokemonType, Long> {

    List<PokemonType> findByName(String name);
}
