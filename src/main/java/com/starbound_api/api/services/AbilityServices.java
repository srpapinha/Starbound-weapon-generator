package com.starbound_api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starbound_api.api.domain.Ability;
import com.starbound_api.api.domain.Weapon;
import com.starbound_api.api.repository.AbilityRepository;
import com.starbound_api.api.repository.WeaponRepository;

@Service
public class AbilityServices {
    @Autowired
    private AbilityRepository abilityRepository;
    @Autowired
    private WeaponRepository weaponRepository;

    public List<Ability> find(String name) {
        Weapon weapon = weaponRepository.findByName(name);
        return abilityRepository.findByWeapon(weapon);
    }
}
