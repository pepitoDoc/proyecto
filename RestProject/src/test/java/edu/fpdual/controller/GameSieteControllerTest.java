package edu.fpdual.controller;

import edu.fpdual.api.dto.GameSiete;
import edu.fpdual.service.GameSieteService;
import jakarta.ws.rs.core.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GameSieteControllerTest {

    @Mock
    private GameSieteService gameSieteServiceMock;

    @Mock
    private java.sql.Date date;

    @InjectMocks
    private GameSieteController gameSieteControllerMock;

    @Mock
    private GameSiete gameSieteMock;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterGame_ok() throws SQLException, ClassNotFoundException {

        GameSiete expectedGameSiete = GameSiete.builder()
                .player1("Alvaro")
                .player2("Artem")
                .player3("Gisela")
                .dealer("Juan")
                .player1score(5)
                .player2score(4)
                .player3score(8)
                .dealerScore(6.5f)
                .player1bet(2)
                .player2bet(1.33f)
                .player3bet(1)
                .timestamp(date)
                .build();

        Response response = gameSieteControllerMock.insertGame(expectedGameSiete);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testFindByName_ok() throws SQLException, ClassNotFoundException{

        Response response = gameSieteControllerMock.findGameByName("");
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

    }



}
