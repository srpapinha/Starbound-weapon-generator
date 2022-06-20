package com.starbound_api.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starbound_api.api.domain.Weapon;
import com.starbound_api.api.services.WeaponServices;

@RestController
@RequestMapping(value = "/weapons")
public class WeaponResource {
    @Autowired
    private WeaponServices WeaponServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Weapon>> list() {
        return ResponseEntity.ok(WeaponServices.list());
    }
}