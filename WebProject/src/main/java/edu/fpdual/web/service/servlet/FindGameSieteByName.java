package edu.fpdual.web.service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fpdual.web.client.GameSieteClient;
import edu.fpdual.web.dto.GameSiete;
import edu.fpdual.web.dto.RankingSiete;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="FindGameByName", urlPatterns = "/findgameby-name")
public class FindGameSieteByName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestBody = req.getParameter("nombre");
        if (requestBody == null || requestBody.isEmpty()) {
            resp.setContentType("text/plain");
            resp.getWriter().write("0");
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        List<GameSiete> dataRetrieved = new GameSieteClient().findByName(requestBody);
        if (dataRetrieved != null) {
            long winCount = new RankingSiete().infoGana(requestBody, dataRetrieved);
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("gameData", dataRetrieved);
            responseMap.put("winCount", winCount);
            resp.setContentType("application/json");
            resp.getWriter().write(mapper.writeValueAsString(responseMap));
        } else {
            resp.setContentType("text/plain");
            resp.getWriter().write("0");
        }
    }
}
