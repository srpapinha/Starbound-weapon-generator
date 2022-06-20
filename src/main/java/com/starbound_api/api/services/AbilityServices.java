package com.starbound_api.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starbound_api.api.domain.Ability;
import com.starbound_api.api.repository.AbilityRepository;

@Service
public class AbilityServices {
    @Autowired
    private AbilityRepository AbilityRepository;

    public List<Ability> find(String weapon) {
        return AbilityRepository.findByWeapon(weapon);
    }
}
