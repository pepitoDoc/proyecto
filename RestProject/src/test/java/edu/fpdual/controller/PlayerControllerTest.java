package edu.fpdual.controller;

import edu.fpdual.api.dto.Player;
import edu.fpdual.service.PlayerService;
import jakarta.ws.rs.core.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerControllerMock;

    @Mock
    private PlayerService playerServiceMock;

    @Spy
    private Player playerMock;

    @Test
    public void testInsertUser_ok() throws SQLException, ClassNotFoundException {

        Player expectedPlayer = Player.builder()
                .nickname("Dummmy")
                .password("123")
                .email("dummy@email.com")
                .build();

        Response response = playerControllerMock.insertPlayer(expectedPlayer);
        MatcherAssert.assertThat(response.getStatus(), Matchers.is(201));

    }

    @Test
    public void testFindPlayerByName_ok() throws SQLException, ClassNotFoundException{

        Response response = playerControllerMock.findPlayerByName("");
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

    }

    @Test
    public void testFindPlayer_ok() throws SQLException, ClassNotFoundException{

        Response response = playerControllerMock.findPlayer("", "");
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

    }

}

