package edu.fpdual.api.dao;

import edu.fpdual.api.dto.Player;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class PlayerTest {

    @Mock
    private ResultSet result;

    @Test
    public void playerConstruction_ok() throws SQLException {

        Player expectedPlayer = Player.builder()
                .nickname("Pepe")
                .password("123")
                .email("paco@gmail.com")
                .build();

        when(result.getString(anyString())).thenAnswer(new Answer<String>() {

           @Override
           public String answer(InvocationOnMock invocationOnMock) {

               if(invocationOnMock.getArgument(0).equals("nickname")) {
                   return expectedPlayer.getNickname();
               } else if (invocationOnMock.getArgument(0).equals("password")) {
                   return expectedPlayer.getPassword();
               } else if (invocationOnMock.getArgument(0).equals("email")) {
                   return expectedPlayer.getEmail();
               } else {
                   return null;
               }
           }
        });

        Player actualPlayer = new Player(result);
        MatcherAssert.assertThat(actualPlayer, Matchers.is(actualPlayer));
    }

    @Test
    void gameConstruction_ko() throws SQLException {

        when(result.getString("nickname")).thenThrow(new SQLException("Mock SQLException"));

        assertThrows(RuntimeException.class, () -> new Player(result));

    }
}