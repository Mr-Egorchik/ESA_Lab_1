package com.example.demo.servlets;

import com.example.demo.dao.CharacterDAO;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "deleteCharacter", value = "/characters/delete")
public class CharacterDeleteServlet extends HttpServlet {

    @Inject
    CharacterDAO service;

    public void init() throws ServletException {
        super.init();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UUID uuid = UUID.fromString(request.getParameter("id"));

        service.deleteById(uuid);

        response.sendRedirect(request.getContextPath() + "/characters");
    }

    public void destroy() {    }

}
