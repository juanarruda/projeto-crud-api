package com.crud.ProjetoCrudApi.rest;

import com.crud.ProjetoCrudApi.dto.EntidadeFormDTO;
import com.crud.ProjetoCrudApi.dto.EntidadeListaDTO;
import com.crud.ProjetoCrudApi.service.FormService;
import com.crud.ProjetoCrudApi.service.ListaService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@Path("/lista")
public class ListaRest {
    Logger logger = Logger.getLogger("Log");

    @Inject
    private ListaService listaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTabelaCliente() {

        List<EntidadeListaDTO> resposta = null;
        try {
            resposta = listaService.ListarUsuarios();
            return Response.ok().type(MediaType.APPLICATION_JSON)
                    .entity(resposta)
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } catch (SQLException e) {
            logger.severe(e.getLocalizedMessage());
            return Response.status(500).entity("Não foi possível listar usuários").build();
        }
    }
}
