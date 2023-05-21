package edu.fpdual.api.dto;

import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class GameSiete {

    private String player1;
    private String player2;
    private String player3;
    private String dealer;
    private float player1score;
    private float player2score;
    private float player3score;
    private float dealerScore;
    private float player1bet;
    private float player2bet;
    private float player3bet;
    private Date timestamp;

    public GameSiete(ResultSet result) {
        try {
            this.player1 = result.getString("player1");
            this.player2 = result.getString("player2");
            this.player3 = result.getString("player3");
            this.dealer = result.getString("dealer");
            this.player1score = result.getFloat("player1score");
            this.player2score = result.getFloat("player2score");
            this.player3score = result.getFloat("player3score");
            this.dealerScore = result.getFloat("dealerScore");
            this.player1bet = result.getFloat("player1bet");
            this.player2bet = result.getFloat("player2bet");
            this.player3bet = result.getFloat("player3bet");
            this.timestamp = result.getDate("timestamp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
