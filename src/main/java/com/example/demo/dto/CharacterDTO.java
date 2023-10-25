package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class CharacterDTO implements Serializable {

    private UUID id;
    private String name;
    private int hp;
    private int attack;
    private int defence;
    private int level;
    private int experience;
    private List<ArtefactDTO> artefacts;
    private WeaponDTO weapon;

    public CharacterDTO(UUID id, String name, int hp, int attack, int defence, int level, int experience, List<ArtefactDTO> artefacts, WeaponDTO weapon) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.level = level;
        this.experience = experience;
        this.artefacts = artefacts;
        this.weapon = weapon;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<ArtefactDTO> getArtefacts() {
        return artefacts;
    }

    public void setArtefacts(List<ArtefactDTO> artefacts) {
        this.artefacts = artefacts;
    }

    public WeaponDTO getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponDTO weapon) {
        this.weapon = weapon;
    }
}
