package edu.fpdual.persistence.manager;

import edu.fpdual.api.dto.Player;

import java.sql.Connection;

public interface PlayerManager extends Manager<Player>{

    int insert(Connection con, Player player);

}
