package com.example.demo.dto;

import java.io.Serializable;
import java.util.UUID;

public class ArtefactDTO implements Serializable {

    private UUID id;

    private String name;

    private UUID bonus;

    private UUID owner;

    public ArtefactDTO(UUID id, String name, UUID bonus, UUID owner) {
        this.id = id;
        this.name = name;
        this.bonus = bonus;
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

    public UUID getBonus() {
        return bonus;
    }

    public void setBonus(UUID bonus) {
        this.bonus = bonus;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }
}
