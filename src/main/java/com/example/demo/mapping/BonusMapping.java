package com.example.demo.mapping;

import com.example.demo.dao.ArtefactDAO;
import com.example.demo.dto.ArtefactDTO;
import com.example.demo.dto.BonusDTO;
import com.example.demo.entity.Artefact;
import com.example.demo.entity.Bonus;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class BonusMapping {

    @Inject
    ArtefactMapping artefactMapping;

    @Inject
    ArtefactDAO artefactDAO;

    public Bonus dtoToEntity(BonusDTO bonusDTO) {
        List<Artefact> artefactList = new ArrayList<>();
        Bonus bonus = new Bonus();
        bonus.setId(bonusDTO.getId());
        bonus.setBonusType(bonusDTO.getBonusType());
        bonus.setBonusValue(bonusDTO.getBonusValue());
        for (ArtefactDTO artefactDTO: bonusDTO.getArtefacts()) {
            artefactList.add(artefactDAO.read(artefactDTO.getId()));
        }
        bonus.setArtefacts(artefactList);
        return bonus;
    }

    public BonusDTO entityToDTO(Bonus bonus) {
        List<ArtefactDTO> artefactDTOList = new ArrayList<>();
        for (Artefact artefact: bonus.getArtefacts()) {
            artefactDTOList.add(artefactMapping.entityToDTO(artefact));
        }
        return new BonusDTO(bonus.getId(), bonus.getBonusType(), bonus.getBonusValue(), artefactDTOList);
    }
}
