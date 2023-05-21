package edu.fpdual.web.service.servlet;

import edu.fpdual.web.client.GameSieteClient;
import edu.fpdual.web.dto.GameSiete;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="RegisterGame", urlPatterns = "/register-game")
public class RegisterGameSiete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GameSiete gameSiete = GameSiete.builder()
                .player1(req.getParameter("player1"))
                .player2(req.getParameter("player2"))
                .player3(req.getParameter("player3"))
                .dealer(req.getParameter("dealer"))
                .player1score(Float.parseFloat(req.getParameter("player1score")))
                .player2score(Float.parseFloat(req.getParameter("player2score")))
                .player3score(Float.parseFloat(req.getParameter("player3score")))
                .dealerScore(Float.parseFloat(req.getParameter("dealerScore")))
                .player1bet(Float.parseFloat(req.getParameter("player1bet")))
                .player2bet(Float.parseFloat(req.getParameter("player2bet")))
                .player3bet(Float.parseFloat(req.getParameter("player3bet")))
                .build();

        new GameSieteClient().registerGame(gameSiete);
        resp.sendRedirect("/WebProject/sieteResolucion/resolucion.jsp");
    }
}