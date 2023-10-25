package com.example.demo.dto;

import com.example.demo.entity.BonusType;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class BonusDTO implements Serializable {

    private UUID id;

    private BonusType bonusType;

    private int bonusValue;

    private List<ArtefactDTO> artefacts;

    public BonusDTO(UUID id, BonusType bonusType, int bonusValue, List<ArtefactDTO> artefacts) {
        this.id = id;
        this.bonusType = bonusType;
        this.bonusValue = bonusValue;
        this.artefacts = artefacts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<ArtefactDTO> getArtefacts() {
        return artefacts;
    }

    public void setArtefacts(List<ArtefactDTO> artefacts) {
        this.artefacts = artefacts;
    }
}
