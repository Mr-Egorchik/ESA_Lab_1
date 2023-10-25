package com.example.demo.servlets;

import com.example.demo.dao.CharacterDAO;
import com.example.demo.dto.CharacterDTO;
import com.example.demo.entity.Character;
import com.example.demo.mapping.CharacterMapping;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getAllCharacters", value = "/characters")
public class CharacterGetAllServlet extends HttpServlet {

    @Inject
    CharacterDAO service;

    @Inject
    CharacterMapping mapping;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Character> characters = service.readAll();
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        for (Character character: characters) {
            characterDTOList.add(mapping.entityToDTO(character));        }

        request.setAttribute("characters", characterDTOList);
        getServletContext().getRequestDispatcher("/characters.jsp").forward(request, response);
    }

    public void destroy() {    }

}
