package com.starbound_api.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starbound_api.api.domain.Projectile;
import com.starbound_api.api.repository.ProjectileRepository;

@Service
public class ProjectileServices {
    @Autowired
    private ProjectileRepository projectileRepository;

    public List<Projectile> list() {
        return projectileRepository.findAll();
    }

    public Optional<Projectile> find(String projectile) {
        return projectileRepository.findByName(projectile);
    }
}
