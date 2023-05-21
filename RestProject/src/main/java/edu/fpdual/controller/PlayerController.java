package edu.fpdual.controller;

import edu.fpdual.api.dto.Player;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.PlayerManagerImpl;
import edu.fpdual.service.PlayerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/player")
public class PlayerController {

    private PlayerService service;

    @POST
    @Path("/insertPlayer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPlayer(Player player) throws SQLException, ClassNotFoundException{

        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        service.insertPlayer(player);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/findPlayer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlayer(
            @QueryParam("nickname") String nickname, @QueryParam("email") String email)
            throws SQLException, ClassNotFoundException {

        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        Player playerFound = service.findPlayer(nickname, email);
        return Response.ok().entity(playerFound).status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/findPlayerByName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlayerByName(
            @QueryParam("nickname") String nickname)
            throws SQLException, ClassNotFoundException {

        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        Player playerFound = service.findPlayerByName(nickname);
        return Response.ok().entity(playerFound).status(Response.Status.CREATED).build();
    }
}
