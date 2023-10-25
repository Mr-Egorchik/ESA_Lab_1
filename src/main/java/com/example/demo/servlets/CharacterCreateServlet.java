package com.example.demo.servlets;

import com.example.demo.dao.CharacterDAO;
import com.example.demo.dao.WeaponDAO;
import com.example.demo.dto.WeaponDTO;
import com.example.demo.entity.Character;
import com.example.demo.entity.Weapon;
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
import java.util.Objects;
import java.util.UUID;

@WebServlet(name = "createCharacter", value = "/characters/create")
public class CharacterCreateServlet extends HttpServlet {

    @Inject
    CharacterDAO service;

    @Inject
    WeaponDAO weaponDAO;

    @Inject
    WeaponMapping weaponMapping;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<WeaponDTO> weaponDTOList = new ArrayList<>();
        for (Weapon weapon: weaponDAO.readAll())
            weaponDTOList.add(weaponMapping.entityToDTO(weapon));
        request.setAttribute("weapons", weaponDTOList);
        getServletContext().getRequestDispatcher("/new_character.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int hp = Integer.parseInt(request.getParameter("hp"));
        int attack = Integer.parseInt(request.getParameter("attack"));
        int defence = Integer.parseInt(request.getParameter("defence"));
        int level = Integer.parseInt(request.getParameter("level"));
        int experience = Integer.parseInt(request.getParameter("experience"));
        String uuid = request.getParameter("weapon");

        Character character = new Character();
        character.setName(name);
        character.setHp(hp);
        character.setAttack(attack);
        character.setDefence(defence);
        character.setLevel(level);
        character.setExperience(experience);
        if (!Objects.equals(uuid, ""))
            character.setWeapon(weaponDAO.read(UUID.fromString(uuid)));

        service.create(character);

        response.sendRedirect(request.getContextPath() + "/characters");
    }

    public void destroy() {    }

}
