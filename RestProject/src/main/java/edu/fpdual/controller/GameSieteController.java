package edu.fpdual.controller;

import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameSieteManagerImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import edu.fpdual.api.dto.GameSiete;
import edu.fpdual.service.GameSieteService;

import java.util.List;

import java.sql.SQLException;



@Path("/gameSiete")
public class GameSieteController {

    private GameSieteService service;

    @POST
    @Path("/insertGame")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertGame(GameSiete gameSiete) throws SQLException, ClassNotFoundException {
        service = new GameSieteService(new MySQLConnector(), new GameSieteManagerImpl());
        service.insertGame(gameSiete);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/findByName")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findGameByName(@QueryParam("nickname") String nickname) throws SQLException, ClassNotFoundException {

        service = new GameSieteService(new MySQLConnector(), new GameSieteManagerImpl());
        List<GameSiete> listado = service.findGameByName(nickname);
        return Response.ok().entity(listado)
                .status(Response.Status.CREATED).build();
    }
}