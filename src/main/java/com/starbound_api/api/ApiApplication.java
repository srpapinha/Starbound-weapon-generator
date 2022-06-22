package com.starbound_api.api;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.starbound_api.api.domain.Ability;
import com.starbound_api.api.domain.Element;
import com.starbound_api.api.domain.Weapon;
import com.starbound_api.api.repository.AbilityRepository;
import com.starbound_api.api.repository.ElementRepository;
import com.starbound_api.api.repository.WeaponRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	@Autowired
	ElementRepository elementRepository;
	@Autowired
	AbilityRepository abilityRepository;
	@Autowired
	WeaponRepository weaponRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Element fire, ice, poison, eletric;
		fire = new Element(null, "fire");
		ice = new Element(null, "ice");
		poison = new Element(null, "poison");
		eletric= new Element(null, "eletric");
		elementRepository.saveAll(Arrays.asList(fire, ice, poison, eletric));

		Scanner scanner = new Scanner(new File("C:\\Users\\Danie\\OneDrive\\Documentos\\teste\\csv\\weapons.csv"));
		List<Weapon> weapons = new LinkedList<>();
		while(scanner.hasNext()) {
			weapons.add(new Weapon(null, scanner.next(), scanner.next(), scanner.nextBoolean()));
		}
		scanner.close();
		weaponRepository.saveAll(weapons);

		scanner = new Scanner(new File("C:\\Users\\Danie\\OneDrive\\Documentos\\teste\\csv\\abilities.csv"));
		List<Ability> abilities = new LinkedList<>();
		while(scanner.hasNext()) {
			Weapon obj = weaponRepository.findByName(scanner.next());
			abilities.add(new Ability(null, obj, scanner.next()));
		}
		scanner.close();
		abilityRepository.saveAll(abilities);
	}
}
