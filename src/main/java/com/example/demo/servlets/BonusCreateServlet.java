package com.example.demo.servlets;

import com.example.demo.dao.BonusDAO;
import com.example.demo.entity.Bonus;
import com.example.demo.entity.BonusType;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "createBonus", value = "/bonuses/create")
public class BonusCreateServlet extends HttpServlet {
    @Inject
    BonusDAO service;

    public void init() throws ServletException {
        super.init();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("types", BonusType.values());
        getServletContext().getRequestDispatcher("/new_bonus.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int type = Integer.parseInt(request.getParameter("type"));
        int value = Integer.parseInt(request.getParameter("value"));

        Bonus bonus = new Bonus();
        bonus.setBonusType(BonusType.values()[type]);
        bonus.setBonusValue(value);

        service.create(bonus);

        response.sendRedirect(request.getContextPath() + "/bonuses");
    }

    public void destroy() {    }
}
