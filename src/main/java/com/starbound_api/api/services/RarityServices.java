package com.starbound_api.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starbound_api.api.domain.Rarity;
import com.starbound_api.api.repository.RarityRepository;

@Service
public class RarityServices {
    @Autowired
    private RarityRepository RarityRepository;

    public List<Rarity> list() {
        return RarityRepository.findAll();
    }

    public Optional<Rarity> find(String name) {
        return RarityRepository.findByName(name);
    }
}