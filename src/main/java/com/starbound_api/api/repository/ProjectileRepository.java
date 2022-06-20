package com.starbound_api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starbound_api.api.domain.Projectile;

public interface ProjectileRepository extends JpaRepository<Projectile, Integer>{
    Projectile findByName(String name);
}
