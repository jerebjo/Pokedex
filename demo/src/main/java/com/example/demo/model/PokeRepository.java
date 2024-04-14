package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokeRepository extends CrudRepository<Pokemon, Long> {
}
