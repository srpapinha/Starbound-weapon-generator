package com.starbound_api.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starbound_api.api.domain.Rarity;

public interface RarityRepository extends JpaRepository<Rarity, Integer>{
    public Optional<Rarity> findByName(String name);
}
