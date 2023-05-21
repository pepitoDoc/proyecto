package edu.fpdual.web.dto;

import java.util.List;
import java.util.function.Predicate;

public class RankingSiete {

    public long infoGana(String nickname, List<GameSiete> infoRetrieved) {

        List<Predicate<GameSiete>> predicatesWin = List.of(
                gameSiete -> gameSiete.getPlayer1().equals(nickname) && ((gameSiete.getDealerScore() > 7.5f && gameSiete.getPlayer1score() < 7.5f) || (gameSiete.getPlayer1score() > gameSiete.getDealerScore())),
                gameSiete -> gameSiete.getPlayer2().equals(nickname) && ((gameSiete.getDealerScore() > 7.5f && gameSiete.getPlayer2score() < 7.5f) || (gameSiete.getPlayer2score() > gameSiete.getDealerScore())),
                gameSiete -> gameSiete.getPlayer3().equals(nickname) && ((gameSiete.getDealerScore() > 7.5f && gameSiete.getPlayer3score() < 7.5f) || (gameSiete.getPlayer3score() > gameSiete.getDealerScore()))
        );

        long count = infoRetrieved.stream()
                .filter(gameSiete -> predicatesWin.stream().anyMatch(predicate -> predicate.test(gameSiete)))
                .count();

        return count;
    }

}
