package com.starbound_api.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starbound_api.api.domain.Element;

@Repository
public interface ElementRepository extends JpaRepository<Element, Integer> {
    public Optional<Element> findByName(String name);
}
