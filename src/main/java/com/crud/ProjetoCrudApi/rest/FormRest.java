package com.crud.ProjetoCrudApi.rest;

import com.crud.ProjetoCrudApi.dto.EntidadeFormDTO;
import com.crud.ProjetoCrudApi.service.FormService;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/formulario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FormRest {


    @Inject
    private FormService formService;

    @GET
    @Path("/{id}")
    public Response getFormCliente(@PathParam("id") Long id) {

        List<EntidadeFormDTO> resposta = formService.ListarUsuarios(id);
            if(!resposta.isEmpty()) {
                return Response.ok().type(MediaType.APPLICATION_JSON)
                        .entity(resposta)
                        .header("Access-Control-Allow-Origin", "*")
                        .build();
            }else{
            return Response.status(500).entity("Não foi possível listar usuários").build();
        }
    }

    @POST
    @Path("/inserir")
    public Response inserirFormCliente(EntidadeFormDTO entidade) {


        Boolean resposta = formService.inserirFormulario(entidade);
        if (resposta) {
            return Response.ok().status(Response.Status.CREATED)
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } else {
            return Response.notModified()
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        }
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response removerFormCliente(@PathParam("id") Long id) {

        boolean resposta = formService.removerFormulario(id);

        if (resposta) {
            return Response.ok().status(Response.Status.OK)
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } else {
            return Response.notModified()
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        }
    }

/*
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateCity(@FormParam("name") String name,
                               @FormParam("population") int population,
                               @PathParam("id") Long id) {

        City city = new City();
        city.setName(name);
        city.setPopulation(population);

        boolean r = cityService.update(city, id);

        if (r) {
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }
    }*/

}
