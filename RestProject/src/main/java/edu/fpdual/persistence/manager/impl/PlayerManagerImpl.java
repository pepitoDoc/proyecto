package edu.fpdual.persistence.manager.impl;

import edu.fpdual.api.dto.Player;
import edu.fpdual.persistence.manager.PlayerManager;

import java.sql.*;

public class PlayerManagerImpl implements PlayerManager {

    @Override
    public int insert(Connection con, Player player) {
        String sql = "INSERT INTO player(nickname, password, email) VALUES(?, ?, ?)";
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, player.getNickname());
            stmt.setString(2, player.getPassword());
            stmt.setString(3, player.getEmail());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Player findPlayer(Connection con, String nickname, String email) {

        String sql = "SELECT * FROM player WHERE nickname = ? OR email = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nickname);
            stmt.setString(2, email);
            ResultSet result = stmt.executeQuery();
            Player playerFound = null;
            while(result.next()) {
                playerFound = new Player(result);
            }
            return playerFound;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Player findPlayerByName(Connection con, String nickname) {

        String sql = "SELECT * FROM player WHERE nickname = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nickname);
            ResultSet result = stmt.executeQuery();
            Player playerFound = null;
            while(result.next()) {
                playerFound = new Player(result);
            }
            return playerFound;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
