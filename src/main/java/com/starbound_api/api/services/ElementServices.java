package com.starbound_api.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starbound_api.api.domain.Element;
import com.starbound_api.api.repository.ElementRepository;

@Service
public class ElementServices {
    @Autowired
    private ElementRepository elementRepository;

    public List<Element> list() {
        return elementRepository.findAll();
    }
}
