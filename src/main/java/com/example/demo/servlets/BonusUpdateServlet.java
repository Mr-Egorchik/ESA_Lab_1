package com.example.demo.servlets;

import com.example.demo.dao.BonusDAO;
import com.example.demo.dto.BonusDTO;
import com.example.demo.entity.BonusType;
import com.example.demo.mapping.BonusMapping;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "updateBonus", value = "/bonuses/update")
public class BonusUpdateServlet extends HttpServlet {

    @Inject
    BonusDAO service;

    @Inject
    BonusMapping bm;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID uuid = UUID.fromString(request.getParameter("id"));
        BonusDTO bonusDTO = bm.entityToDTO(service.read(uuid));
        request.setAttribute("types", BonusType.values());
        request.setAttribute("bonus", bonusDTO);
        getServletContext().getRequestDispatcher("/update_bonus.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int type = Integer.parseInt(request.getParameter("type"));
        int value = Integer.parseInt(request.getParameter("value"));
        UUID uuid = UUID.fromString(request.getParameter("id"));

        BonusDTO bonusDTO = bm.entityToDTO(service.read(uuid));

        bonusDTO.setBonusType(BonusType.values()[type]);
        bonusDTO.setBonusValue(value);

        service.update(bm.dtoToEntity(bonusDTO));

        response.sendRedirect(request.getContextPath() + "/bonuses");
    }

    public void destroy() {    }

}
