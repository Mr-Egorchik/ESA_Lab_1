package com.example.demo.servlets;

import com.example.demo.dao.WeaponDAO;
import com.example.demo.entity.Weapon;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "createWeapon", value = "/weapons/create")
public class WeaponCreateServlet extends HttpServlet {

    @Inject
    WeaponDAO service;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/new_weapon.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int attack = Integer.parseInt(request.getParameter("attack"));

        Weapon weapon = new Weapon();
        weapon.setName(name);
        weapon.setAttack(attack);

        service.create(weapon);

        response.sendRedirect(request.getContextPath() + "/weapons");
    }

    public void destroy() {    }

}
