package com.example.demo.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptureDetailsRepository extends JpaRepository<CaptureDetails, Long> {
    Optional<CaptureDetails> findByPokemonId(Long pokemonId);
}