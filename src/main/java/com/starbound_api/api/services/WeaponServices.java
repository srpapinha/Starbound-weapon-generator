package com.starbound_api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starbound_api.api.domain.Weapon;
import com.starbound_api.api.repository.WeaponRepository;

@Service
public class WeaponServices {
    @Autowired
    private WeaponRepository weaponRepository;

    public List<Weapon> list() {
        return weaponRepository.findAll();
    }
}