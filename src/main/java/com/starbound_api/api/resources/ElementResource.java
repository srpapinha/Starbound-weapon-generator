package com.starbound_api.api.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.starbound_api.api.domain.Element;
import com.starbound_api.api.services.ElementServices;

@RestController
@RequestMapping(value = "/elements")
public class ElementResource {
    @Autowired
    private ElementServices elementServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Element>> list() {
        return ResponseEntity.ok(elementServices.list());
    }
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] find(@PathVariable String name) throws IOException, SQLException {
        Element obj = elementServices.find(name);
        return obj.getImage().getBinaryStream().readAllBytes();
    }
}
