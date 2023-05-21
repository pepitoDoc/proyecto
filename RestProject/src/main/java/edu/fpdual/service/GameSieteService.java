package edu.fpdual.service;

import edu.fpdual.api.dto.GameSiete;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameSieteManagerImpl;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Getter
public class GameSieteService {

    private MySQLConnector connector;
    private GameSieteManagerImpl manager;
    public GameSieteService(MySQLConnector connector, GameSieteManagerImpl manager) {
        this.connector = connector;
        this.manager = manager;
    }

    public int insertGame(GameSiete gameSiete) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.insert(con, gameSiete);
        } finally {
            if (con!=null) {
                con.close();
            }
        }
    }

    public List<GameSiete> findGameByName(String nickname) throws SQLException, ClassNotFoundException {

        Connection con = null;
        try {
            con = connector.getMySQLConnection();
            return manager.findByName(con, nickname);
        } finally {
            if (con!=null) {
                con.close();
            }
        }
    }

}
