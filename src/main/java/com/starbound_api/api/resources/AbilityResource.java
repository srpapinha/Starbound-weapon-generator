package com.starbound_api.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starbound_api.api.domain.Ability;
import com.starbound_api.api.services.AbilityServices;

@RestController
@RequestMapping(value = "/abilities")
public class AbilityResource {
    @Autowired
    private AbilityServices abilityServices;

    @RequestMapping(value = "/{weapon}",method = RequestMethod.GET)
    public ResponseEntity<List<Ability>> find(@PathVariable String weapon) {
        return ResponseEntity.ok(abilityServices.find(weapon));
    }
}
