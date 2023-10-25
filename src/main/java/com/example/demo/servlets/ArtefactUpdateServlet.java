package com.example.demo.servlets;

import com.example.demo.dao.ArtefactDAO;
import com.example.demo.dao.BonusDAO;
import com.example.demo.dao.CharacterDAO;
import com.example.demo.dto.ArtefactDTO;
import com.example.demo.mapping.ArtefactMapping;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@WebServlet(name = "updateArtefact", value = "/artefacts/update")
public class ArtefactUpdateServlet extends HttpServlet {

    @Inject
    ArtefactDAO service;

    @Inject
    ArtefactMapping bm;

    @Inject
    BonusDAO bonusDAO;

    @Inject
    CharacterDAO characterDAO;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID uuid = UUID.fromString(request.getParameter("id"));
        ArtefactDTO ArtefactDTO = bm.entityToDTO(service.read(uuid));
        request.setAttribute("bonuses", bonusDAO.readAll());
        request.setAttribute("characters", characterDAO.readAll());
        request.setAttribute("artefact", ArtefactDTO);
        getServletContext().getRequestDispatcher("/update_Artefact.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID uuid = UUID.fromString(request.getParameter("id"));
        String name = request.getParameter("name");
        String bonusUuid = request.getParameter("bonus");
        String characterUuid = request.getParameter("character");

        ArtefactDTO artefactDTO = bm.entityToDTO(service.read(uuid));
        artefactDTO.setName(name);
        artefactDTO.setBonus(UUID.fromString(bonusUuid));
        if (!Objects.equals(characterUuid, ""))
            artefactDTO.setOwner(UUID.fromString(characterUuid));

        service.update(bm.dtoToEntity(artefactDTO));

        response.sendRedirect(request.getContextPath() + "/artefacts");
    }

    public void destroy() {    }

}
