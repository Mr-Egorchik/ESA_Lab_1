package com.example.demo.servlets;

import com.example.demo.dao.ArtefactDAO;
import com.example.demo.dao.BonusDAO;
import com.example.demo.dao.CharacterDAO;
import com.example.demo.entity.Artefact;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@WebServlet(name = "createArtefact", value = "/artefacts/create")
public class ArtefactCreateServlet extends HttpServlet {

    @Inject
    ArtefactDAO service;

    @Inject
    BonusDAO bonusDAO;

    @Inject
    CharacterDAO characterDAO;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("bonuses", bonusDAO.readAll());
        request.setAttribute("characters", characterDAO.readAll());
        getServletContext().getRequestDispatcher("/new_artefact.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String bonusUuid = request.getParameter("bonus");
        String characterUuid = request.getParameter("character");

        Artefact artefact = new Artefact();
        artefact.setName(name);
        artefact.setBonus(bonusDAO.read(UUID.fromString(bonusUuid)));
        if (!Objects.equals(characterUuid, ""))
            artefact.setOwner(characterDAO.read(UUID.fromString(characterUuid)));

        service.create(artefact);

        response.sendRedirect(request.getContextPath() + "/artefacts");
    }

    public void destroy() {    }

}
