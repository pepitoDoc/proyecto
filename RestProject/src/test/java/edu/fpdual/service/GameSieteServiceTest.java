package edu.fpdual.service;

import edu.fpdual.api.dto.GameSiete;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameSieteManagerImpl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameSieteServiceTest {

    @Mock
    private MySQLConnector connector;

    @Mock
    private GameSieteManagerImpl gameManager;

    @Mock
    private GameSiete gameSiete;

    @Mock
    private List<GameSiete> gameSieteList;

    @Mock
    private Connection connection;

    @InjectMocks
    private GameSieteService gameSieteServiceMock;

    @Test
    public void gameServiceConstruction_ok() {

        GameSieteService serviceMock = new GameSieteService(connector, gameManager);
        MatcherAssert.assertThat(connector, Matchers.is(serviceMock.getConnector()));
        MatcherAssert.assertThat(gameManager, Matchers.is(serviceMock.getManager()));

    }

    @Test
    public void insertGame_ok() throws SQLException, ClassNotFoundException {

        when(connector.getMySQLConnection()).thenReturn(connection);
        when(gameManager.insert(connection, gameSiete)).thenReturn(1);

        // Perform the test
        int result = gameSieteServiceMock.insertGame(gameSiete);

        // Verify the interactions and assertions
        verify(connection).close();
        MatcherAssert.assertThat(result, Matchers.is(1));

    }

    @Test
    public void findByName_ok() throws SQLException, ClassNotFoundException{

        when(connector.getMySQLConnection()).thenReturn(connection);
        when(gameManager.findByName(connection, "")).thenReturn(gameSieteList);

        // Perform the test
        List<GameSiete> gameSietes = gameSieteServiceMock.findGameByName("");

        // Verify the interactions and assertions
        verify(connection).close();
        MatcherAssert.assertThat(gameSietes, Matchers.is(gameSieteList));

    }

}
