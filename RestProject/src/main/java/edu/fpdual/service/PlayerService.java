package edu.fpdual.service;

import edu.fpdual.api.dto.Player;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.PlayerManagerImpl;
import jakarta.validation.GroupSequence;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

@Getter
public class PlayerService {

    private MySQLConnector connector;
    private PlayerManagerImpl manager;

    public PlayerService(MySQLConnector connector, PlayerManagerImpl manager) {
        this.connector = connector;
        this.manager = manager;
    }

    public int insertPlayer(Player player) throws SQLException, ClassNotFoundException{

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.insert(con, player);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public Player findPlayer(String nickname, String email) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.findPlayer(con, nickname, email);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public Player findPlayerByName(String nickname) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.findPlayerByName(con, nickname);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

}
