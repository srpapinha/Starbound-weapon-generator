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

import com.starbound_api.api.domain.Rarity;
import com.starbound_api.api.services.RarityServices;

@RestController
@RequestMapping(value = "/rarities")
public class RarityResource {
    @Autowired
    private RarityServices rarityServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Rarity>> list() {
        return ResponseEntity.ok(rarityServices.list());
    }
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] find(@PathVariable String name) throws IOException, SQLException {
        Optional<Rarity> obj = rarityServices.find(name);
        return obj.get().getImage().getBinaryStream().readAllBytes();
    }
}