package com.starbound_api.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starbound_api.api.domain.Projectile;
import com.starbound_api.api.services.ProjectileServices;

@RestController
@RequestMapping(value = "/projectiles")
public class ProjectileResource {
    @Autowired
    private ProjectileServices projectileServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Projectile>> list() {
        return ResponseEntity.ok(projectileServices.list());
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public ResponseEntity<Projectile> find(@PathVariable String projectile) {
        return ResponseEntity.ok(projectileServices.find(projectile));
    }
}
