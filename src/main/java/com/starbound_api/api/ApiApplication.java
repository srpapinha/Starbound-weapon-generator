package com.starbound_api.api;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.starbound_api.api.domain.Ability;
import com.starbound_api.api.domain.Element;
import com.starbound_api.api.domain.Projectile;
import com.starbound_api.api.domain.Weapon;
import com.starbound_api.api.repository.AbilityRepository;
import com.starbound_api.api.repository.ElementRepository;
import com.starbound_api.api.repository.ProjectileRepository;
import com.starbound_api.api.repository.WeaponRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	@Autowired
	private ElementRepository elementsRepository;
	@Autowired
	private AbilityRepository abilityRepository;
	@Autowired
	private WeaponRepository weaponRepository;
	@Autowired
	private ProjectileRepository projectileRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(new File("C:\\Users\\Danie\\OneDrive\\Documentos\\teste\\csv\\elements.csv"));
		List<Element> elements = new LinkedList<>();
		while(scanner.hasNext()) {
			File file = new File(scanner.nextLine());
			FileInputStream stream = new FileInputStream(file);
			Element element = new Element(null, file.getName().split("\\.png$")[0]);
			element.setImage(new SerialBlob(stream.readAllBytes()));
			stream.close();
			elements.add(element);
		}
		elementsRepository.saveAll(elements);
		scanner.close();
		
		scanner = new Scanner(new File("C:\\Users\\Danie\\OneDrive\\Documentos\\teste\\csv\\weapons.csv"));
		List<Weapon> weapons = new LinkedList<>();
		while(scanner.hasNext()) {
			weapons.add(new Weapon(null, scanner.next(), scanner.next(), scanner.nextBoolean()));
		}
		scanner.close();
		weaponRepository.saveAll(weapons);

		scanner = new Scanner(new File("C:\\Users\\Danie\\OneDrive\\Documentos\\teste\\csv\\abilities.csv"));
		List<Ability> abilities = new LinkedList<>();
		while(scanner.hasNext()) {
			Optional<Weapon> obj = weaponRepository.findByName(scanner.next());
			abilities.add(new Ability(null, obj.get(), scanner.next()));
		}
		scanner.close();
		abilityRepository.saveAll(abilities);

		scanner = new Scanner(new File("C:\\Users\\Danie\\OneDrive\\Documentos\\teste\\csv\\projectiles.csv"));
		List<Projectile> projectiles = new LinkedList<>();
		while(scanner.hasNext()) {
			File file = new File(scanner.nextLine());
			FileInputStream stream = new FileInputStream(file);
			Projectile projectile = new Projectile(null, new File(file.getParent()).getName(), file.getName().split("\\.png$")[0]);
			projectile.setImage(new SerialBlob(stream.readAllBytes()));
			stream.close();
			projectiles.add(projectile);
		}
		projectileRepository.saveAll(projectiles);
		scanner.close();

	}
}
