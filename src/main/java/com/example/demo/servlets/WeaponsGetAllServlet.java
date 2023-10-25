package com.example.demo.servlets;

import com.example.demo.dao.WeaponDAO;
import com.example.demo.dto.WeaponDTO;
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

@WebServlet(name = "getAllWeapons", value = "/weapons")
public class WeaponsGetAllServlet extends HttpServlet {

    @Inject
    WeaponDAO service;

    @Inject
    WeaponMapping mapping;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Weapon> weapons = service.readAll();
        List<WeaponDTO> weaponDTOList = new ArrayList<>();
        for (Weapon weapon: weapons) {
            weaponDTOList.add(mapping.entityToDTO(weapon));        }

        request.setAttribute("weapons", weaponDTOList);
        getServletContext().getRequestDispatcher("/weapons.jsp").forward(request, response);
    }

    public void destroy() {    }

}
