package com.example.demo.servlets;

import com.example.demo.dao.ArtefactDAO;
import com.example.demo.dto.ArtefactDTO;
import com.example.demo.entity.Artefact;
import com.example.demo.mapping.ArtefactMapping;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getAllArtefacts", value = "/artefacts")
public class ArtefactGetAllServlet extends HttpServlet {

    @Inject
    ArtefactDAO service;

    @Inject
    ArtefactMapping mapping;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Artefact> artefacts = service.readAll();
        List<ArtefactDTO> ArtefactDTOList = new ArrayList<>();
        for (Artefact Artefact: artefacts) {
            ArtefactDTOList.add(mapping.entityToDTO(Artefact));        }

        request.setAttribute("artefacts", ArtefactDTOList);
        getServletContext().getRequestDispatcher("/artefacts.jsp").forward(request, response);
    }

    public void destroy() {    }

}
