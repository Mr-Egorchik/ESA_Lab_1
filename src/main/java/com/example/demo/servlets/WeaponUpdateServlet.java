package com.example.demo.servlets;

import com.example.demo.dao.WeaponDAO;
import com.example.demo.dto.WeaponDTO;
import com.example.demo.mapping.WeaponMapping;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "updateWeapon", value = "/weapons/update")
public class WeaponUpdateServlet extends HttpServlet {

    @Inject
    WeaponDAO service;

    @Inject
    WeaponMapping wm;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID uuid = UUID.fromString(request.getParameter("id"));
        WeaponDTO weaponDTO = wm.entityToDTO(service.read(uuid));
        request.setAttribute("weapon", weaponDTO);
        getServletContext().getRequestDispatcher("/update_weapon.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int attack = Integer.parseInt(request.getParameter("attack"));

        UUID uuid = UUID.fromString(request.getParameter("id"));

        WeaponDTO weaponDTO = wm.entityToDTO(service.read(uuid));

        weaponDTO.setName(name);
        weaponDTO.setAttack(attack);

        service.update(wm.dtoToEntity(weaponDTO));

        response.sendRedirect(request.getContextPath() + "/weapons");
    }

    public void destroy() {    }

}
