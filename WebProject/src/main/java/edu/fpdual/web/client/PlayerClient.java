package edu.fpdual.web.client;

import edu.fpdual.web.dto.Player;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class PlayerClient {

    private final WebTarget webTarget;

    public PlayerClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8081/RestProject/api/player");
    }

    public Player insertUser(Player player) {

        return webTarget.path("/insertPlayer")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(player, MediaType.APPLICATION_JSON), Player.class);
    }

    public Player findPlayer(String nickname, String email) {
        return webTarget.path("/findPlayer")
                .queryParam("nickname", nickname)
                .queryParam("email", email)
                .request(MediaType.APPLICATION_JSON)
                .get(Player.class);
    }

    public Player findPlayerByName(String nickname) {
        return webTarget.path("/findPlayerByName")
                .queryParam("nickname", nickname)
                .request(MediaType.APPLICATION_JSON)
                .get(Player.class);
    }
}