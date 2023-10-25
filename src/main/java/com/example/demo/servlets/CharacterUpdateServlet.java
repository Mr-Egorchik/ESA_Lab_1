package com.example.demo.servlets;

import com.example.demo.dao.CharacterDAO;
import com.example.demo.dao.WeaponDAO;
import com.example.demo.dto.CharacterDTO;
import com.example.demo.dto.WeaponDTO;
import com.example.demo.entity.Character;
import com.example.demo.entity.Weapon;
import com.example.demo.mapping.CharacterMapping;
import com.example.demo.mapping.WeaponMapping;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "updateCharacter", value = "/characters/update")
public class CharacterUpdateServlet extends HttpServlet {

    @Inject
    CharacterDAO service;

    @Inject
    WeaponDAO weaponDAO;

    @Inject
    CharacterMapping cm;

    @Inject
    WeaponMapping wm;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID uuid = UUID.fromString(request.getParameter("id"));
        CharacterDTO characterDTO = cm.entityToDTO(service.read(uuid));
        request.setAttribute("ch", characterDTO);
        List<WeaponDTO> weaponDTOList = new ArrayList<>();
        for (Weapon weapon: weaponDAO.readAll())
            weaponDTOList.add(wm.entityToDTO(weapon));
        request.setAttribute("weapons", weaponDTOList);
        getServletContext().getRequestDispatcher("/update_character.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID uuid = UUID.fromString(request.getParameter("id"));
        String name = request.getParameter("name");
        int hp = Integer.parseInt(request.getParameter("hp"));
        int attack = Integer.parseInt(request.getParameter("attack"));
        int defence = Integer.parseInt(request.getParameter("defence"));
        int level = Integer.parseInt(request.getParameter("level"));
        int experience = Integer.parseInt(request.getParameter("experience"));
        String weapon_uuid = request.getParameter("weapon");

        CharacterDTO characterDTO = cm.entityToDTO(service.read(uuid));
        characterDTO.setName(name);
        characterDTO.setHp(hp);
        characterDTO.setAttack(attack);
        characterDTO.setDefence(defence);
        characterDTO.setLevel(level);
        characterDTO.setExperience(experience);
        if (weapon_uuid != null)
            characterDTO.setWeapon(wm.entityToDTO(weaponDAO.read(UUID.fromString(weapon_uuid))));

        service.update(cm.dtoToEntity(characterDTO));

        response.sendRedirect(request.getContextPath() + "/characters");
    }

    public void destroy() {    }

}
