package edu.fpdual.persistence.manager;

import java.sql.Connection;

public interface Manager<T> {

    int insert(Connection con, T element);

    //void delete(Connection con, String condition);

}
