package com.starbound_api.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ability implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String weapon;
    private String ability_id;

    public Ability() {}

    public Ability(Integer id, String weapon, String ability_id) {
        this.id = id;
        this.weapon = weapon;
        this.ability_id = ability_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getAbility_id() {
        return ability_id;
    }

    public void setAbility_id(String ability_id) {
        this.ability_id = ability_id;
    }

    
}
