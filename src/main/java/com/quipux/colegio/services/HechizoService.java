package com.quipux.colegio.services;

import com.quipux.colegio.manager.HechizoManager;
import com.quipux.colegio.models.HechizoEntity;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/hechizos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HechizoService {

    @Autowired
    private HechizoManager hechizoManager;

    @POST
    public Response crearHechizo(HechizoEntity hechizo) {
        try {
            HechizoEntity hechizoGuardado = hechizoManager.registrarHechizo(hechizo);
            return Response.status(Response.Status.CREATED).entity(hechizoGuardado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    public Response buscarPorTipo(@QueryParam("tipo") String tipo) {
        List<HechizoEntity> lista = hechizoManager.buscarMagia(tipo);
        return Response.ok(lista).build();
    }
}