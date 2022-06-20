package com.starbound_api.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starbound_api.api.domain.Element;
import com.starbound_api.api.services.ElementServices;

@RestController
@RequestMapping(value = "/elements")
public class ElementResource {
    @Autowired
    private ElementServices elementTypeServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Element>> list() {
        return ResponseEntity.ok(elementTypeServices.list());
    }
}
