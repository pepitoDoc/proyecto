package edu.fpdual.persistence.manager;

import edu.fpdual.api.dto.GameSiete;

import java.sql.Connection;

public interface GameManager extends Manager<GameSiete> {

    int insert(Connection con, GameSiete gameSiete);



}
