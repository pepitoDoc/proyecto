package edu.fpdual.web.service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fpdual.web.client.PlayerClient;
import edu.fpdual.web.dto.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="FindPlayer", urlPatterns = "/findplayer")
public class FindPlayer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        Player player = mapper.readValue(req.getReader(), Player.class);

        String result = "0";

        Player playerFound = new PlayerClient().findPlayer(player.getNickname(), player.getEmail());
        if ((player.getNickname().equals(playerFound.getNickname()))
                || player.getEmail().equals(playerFound.getEmail())) {
            result = "1";
        }
        resp.setContentType("text/plain");
        resp.getWriter().write(result);
    }
}
