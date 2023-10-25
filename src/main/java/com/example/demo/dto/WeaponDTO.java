package com.example.demo.dto;

import com.example.demo.entity.Character;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.UUID;

public class WeaponDTO implements Serializable {

    private UUID id;
    private String name;
    private int attack;
    private UUID owner;

    public WeaponDTO(UUID id, String name, int attack, UUID owner) {
        this.id = id;
        this.name = name;
        this.attack = attack;
        this.owner = owner;
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }
}
