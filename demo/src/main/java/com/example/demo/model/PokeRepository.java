package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByName(String name);
}
