package edu.fpdual.api.dto;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class Player {
    private String nickname;
    private String password;
    private String email;

    public Player(ResultSet result) {
        try {
            this.nickname = result.getString("nickname");
            this.password = result.getString("password");
            this.email = result.getString("email");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
