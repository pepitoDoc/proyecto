package edu.fpdual.service;

import edu.fpdual.api.dto.Player;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.PlayerManagerImpl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private MySQLConnector connectorMock;

    @Mock
    private PlayerManagerImpl playerManagerMock;

    @Mock
    private Player playerMock;

    @Mock
    private Connection connection;

    @InjectMocks
    private PlayerService playerServiceMock;

    @Test
    public void playerServiceConstruction_ok() {

        PlayerService serviceMock = new PlayerService(connectorMock, playerManagerMock);
        MatcherAssert.assertThat(connectorMock, Matchers.is(serviceMock.getConnector()));
        MatcherAssert.assertThat(playerManagerMock, Matchers.is(serviceMock.getManager()));

    }

    @Test
    public void testInsertPlayer_ok() throws SQLException, ClassNotFoundException {

        when(connectorMock.getMySQLConnection()).thenReturn(connection);
        when(playerManagerMock.insert(connection, playerMock)).thenReturn(1);

        int result = playerServiceMock.insertPlayer(playerMock);

        verify(connection).close();
        MatcherAssert.assertThat(result, Matchers.is(1));

    }

    @Test
    public void testFindPlayerByName_ok() throws SQLException, ClassNotFoundException {

        when(connectorMock.getMySQLConnection()).thenReturn(connection);
        when(playerManagerMock.findPlayerByName(connection, "")).thenReturn(playerMock);

        // Perform the test
        Player playerFound = playerServiceMock.findPlayerByName("");

        // Verify the interactions and assertions
        verify(connection).close();
        MatcherAssert.assertThat(playerFound, Matchers.is(playerMock));

    }

    @Test
    public void testFindPlayer_ok() throws SQLException, ClassNotFoundException {

        when(connectorMock.getMySQLConnection()).thenReturn(connection);
        when(playerManagerMock.findPlayer(connection, "", "")).thenReturn(playerMock);

        // Perform the test
        Player playerFound = playerServiceMock.findPlayer("", "");

        // Verify the interactions and assertions
        verify(connection).close();
        MatcherAssert.assertThat(playerFound, Matchers.is(playerMock));

    }

}
