package com.example.demo.mapping;

import com.example.demo.dao.BonusDAO;
import com.example.demo.dao.CharacterDAO;
import com.example.demo.dto.ArtefactDTO;
import com.example.demo.entity.Artefact;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ArtefactMapping {

    @Inject
    BonusDAO bonusDAO;

    @Inject
    CharacterDAO characterDAO;

    public Artefact dtoToEntity(ArtefactDTO artefactDTO) {
        Artefact artefact = new Artefact();
        artefact.setId(artefactDTO.getId());
        artefact.setName(artefactDTO.getName());
        if (artefactDTO.getBonus() != null)
            artefact.setBonus(bonusDAO.read(artefactDTO.getBonus()));
        if (artefactDTO.getOwner() != null)
            artefact.setOwner(characterDAO.read(artefactDTO.getOwner()));
        return artefact;
    }

    public ArtefactDTO entityToDTO(Artefact artefact) {
        return new ArtefactDTO(artefact.getId(), artefact.getName(), artefact.getBonus().getId(), artefact.getOwner().getId());
    }
}
