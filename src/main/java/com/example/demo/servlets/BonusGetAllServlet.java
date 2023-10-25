package com.example.demo.servlets;

import com.example.demo.dao.BonusDAO;
import com.example.demo.dto.BonusDTO;
import com.example.demo.entity.Bonus;
import com.example.demo.mapping.BonusMapping;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "getAllBonuses", value = "/bonuses")
public class BonusGetAllServlet extends HttpServlet {

    @Inject
    BonusDAO service;

    @Inject
    BonusMapping mapping;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Bonus> bonuses = service.readAll();
        List<BonusDTO> bonusDTOList = new ArrayList<>();
        for (Bonus bonus: bonuses) {
            bonusDTOList.add(mapping.entityToDTO(bonus));        }

        request.setAttribute("bonuses", bonusDTOList);
        getServletContext().getRequestDispatcher("/bonuses.jsp").forward(request, response);
    }

    public void destroy() {    }
}
