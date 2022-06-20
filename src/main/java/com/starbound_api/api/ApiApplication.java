package com.starbound_api.api;

import java.util.Arrays;

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

		Ability abi1, abi2, abi3;
		abi1 = new Ability(null, "broadsword", "parry");
		abi2 = new Ability(null, "broadsword", "bladecharge");
		abi3 = new Ability(null, "broadsword", "downstab");
		abilityRepository.saveAll(Arrays.asList(abi1, abi2, abi3));

		Weapon wea1, wea2, wea3;
		wea1 = new Weapon(null, "broadsword", "melee", true);
		wea2 = new Weapon(null, "hammer", "melee", true);
		wea3 = new Weapon(null, "spear", "melee", true);
		weaponRepository.saveAll(Arrays.asList(wea1, wea2, wea3));
	}
}
