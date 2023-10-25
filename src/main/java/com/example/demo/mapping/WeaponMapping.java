package com.example.demo.mapping;

import com.example.demo.dao.CharacterDAO;
import com.example.demo.dto.WeaponDTO;
import com.example.demo.entity.Character;
import com.example.demo.entity.Weapon;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class WeaponMapping {

    @Inject
    CharacterDAO characterDAO;

    public WeaponDTO entityToDTO(Weapon weapon) {
        Character owner = weapon.getOwner();
        return new WeaponDTO(weapon.getId(), weapon.getName(), weapon.getAttack(), owner == null ? null : owner.getId());
    }

    public Weapon dtoToEntity(WeaponDTO weaponDTO) {
        Weapon weapon = new Weapon();
        weapon.setId(weaponDTO.getId());
        weapon.setName(weaponDTO.getName());
        weapon.setAttack(weaponDTO.getAttack());
        if (weapon.getOwner() != null)
            weapon.setOwner(characterDAO.read(weaponDTO.getOwner()));
        return weapon;
    }
}
