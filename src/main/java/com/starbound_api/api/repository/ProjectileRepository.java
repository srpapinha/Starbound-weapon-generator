package com.starbound_api.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starbound_api.api.domain.Projectile;

@Repository
public interface ProjectileRepository extends JpaRepository<Projectile, Integer>{
    public Optional<Projectile> findByName(String name);
}
