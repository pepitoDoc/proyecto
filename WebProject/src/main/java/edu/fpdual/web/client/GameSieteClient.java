package edu.fpdual.web.client;

import edu.fpdual.web.dto.GameSiete;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

public class GameSieteClient {

    private final WebTarget webTarget;

    public GameSieteClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8081/RestProject/api/");
    }

    public GameSiete registerGame(GameSiete gameSiete) {

        return webTarget.path("gameSiete/insertGame")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(gameSiete, MediaType.APPLICATION_JSON), GameSiete.class);

    }

    public List<GameSiete> findByName(String nickname) {
        return webTarget.path("gameSiete/findByName")
                .queryParam("nickname", nickname)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<GameSiete>>(){});
    }

}
