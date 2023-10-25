package com.example.demo.mapping;

import com.example.demo.dto.ArtefactDTO;
import com.example.demo.dto.BonusDTO;
import com.example.demo.dto.CharacterDTO;
import com.example.demo.entity.Artefact;
import com.example.demo.entity.Bonus;
import com.example.demo.entity.Character;
import com.example.demo.entity.Weapon;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class CharacterMapping {

    @Inject
    ArtefactMapping artefactMapping;

    @Inject
    WeaponMapping weaponMapping;

    public Character dtoToEntity(CharacterDTO characterDTO) {
        Character character = new Character();
        character.setId(characterDTO.getId());
        character.setName(characterDTO.getName());
        character.setHp(characterDTO.getHp());
        character.setAttack(characterDTO.getAttack());
        character.setDefence(characterDTO.getDefence());
        character.setLevel(characterDTO.getLevel());
        character.setExperience(characterDTO.getExperience());
        if (characterDTO.getWeapon() != null)
            character.setWeapon(weaponMapping.dtoToEntity(characterDTO.getWeapon()));
        List<Artefact> artefacts = new ArrayList<>();
        for (ArtefactDTO artefactDTO: characterDTO.getArtefacts())
            artefacts.add(artefactMapping.dtoToEntity(artefactDTO));
        return character;
    }

    public CharacterDTO entityToDTO(Character character) {
        List<ArtefactDTO> artefactDTOList = new ArrayList<>();
        for (Artefact artefact: character.getArtefacts()) {
            artefactDTOList.add(artefactMapping.entityToDTO(artefact));
        }
        Weapon weapon = character.getWeapon();
        return new CharacterDTO(character.getId(), character.getName(), character.getHp(), character.getAttack(), character.getDefence(), character.getLevel(), character.getExperience(), artefactDTOList, weapon == null ? null : weaponMapping.entityToDTO(weapon));
    }
}
