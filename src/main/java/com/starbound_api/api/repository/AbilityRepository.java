package com.starbound_api.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starbound_api.api.domain.Ability;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, Integer> {
    List<Ability> findByWeapon(String weapon);
}
