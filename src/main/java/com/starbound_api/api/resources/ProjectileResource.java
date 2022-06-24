package com.starbound_api.api.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/{name}",method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] find(@PathVariable String name) throws IOException, SQLException {
        Optional<Projectile> obj = projectileServices.find(name);
        return obj.get().getImage().getBinaryStream().readAllBytes();
    }
}
