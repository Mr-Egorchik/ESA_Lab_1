package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bonuses")
public class Bonus {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "bonus_type")
    private BonusType bonusType;

    @Column(name = "bonus_value")
    private int bonusValue;

    @OneToMany(mappedBy = "bonus")
    private List<Artefact> artefacts;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public BonusType getBonusType() {
        return bonusType;
    }

    public void setBonusType(BonusType bonusType) {
        this.bonusType = bonusType;
    }

    public int getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(int bonusValue) {
        this.bonusValue = bonusValue;
    }

    public List<Artefact> getArtefacts() {
        return artefacts;
    }

    public void setArtefacts(List<Artefact> artefacts) {
        this.artefacts = artefacts;
    }
}
