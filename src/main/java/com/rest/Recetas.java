package com.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/recetas")
public class Recetas {

    RecetaServicio  recetaServicio = new RecetaServicio();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtieneTodosLosEstudiantes(@Context HttpHeaders headers){
        List<Receta> recetas = recetaServicio.obtieneRecetas();
        GenericEntity<List<Receta>> entidad = new GenericEntity<List<Receta>>(recetas){};
        return Response.status(Response.Status.OK).entity(entidad).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtiene/{tipoReceta}")
    public Response obtieneTipoReceta(@PathParam("tipoReceta")int tipoReceta){
        Receta receta = recetaServicio.obtieneTipoReceta(tipoReceta);

        if(receta != null){
            return Response.status(Response.Status.FOUND).entity(receta).build();
        } else{
            return Response.status(Response.Status.NOT_FOUND).entity(receta).build();
        }
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/agrega")
    public Response agregaReceta(Receta receta){
        String strReceta = recetaServicio.agregaReceta(receta);

        if(receta != null){
            return Response.status(Response.Status.FOUND).entity(strReceta).build();
        } else{
            return Response.status(Response.Status.NOT_FOUND).entity(strReceta).build();
        }
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/actualiza/{id}")
    public Response actualizaReceta(@PathParam("id")int id,Receta receta){
        String strReceta = recetaServicio.actualizaReceta(id,receta);

        if(receta != null){
            return Response.status(Response.Status.FOUND).entity(strReceta).build();
        } else{
            return Response.status(Response.Status.NOT_FOUND).entity(strReceta).build();
        }
    }

}
