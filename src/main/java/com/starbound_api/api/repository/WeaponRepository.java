package com.starbound_api.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starbound_api.api.domain.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
    public Optional<Weapon> findByName(String name);
}
