package com.recetario.servicio;

import com.recetario.*;
import com.recetario.modelo.Receta;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//     https://www.baeldung.com/java-json-binding-api
//      Jsonb jsonB = JsonbBuilder.create();
//        String jsonListReceta = jsonB.toJson(this.recetas);

@Path("/recetario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecetarioServicio implements IRecetarioServicio {


    private static List<Receta> recetas = new ArrayList<Receta>();


    public RecetarioServicio() {

    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response Mensaje(@Context HttpHeaders headers) {
        String mensaje =
                "<h1>Este es el servicio Restful de Recetario</h1>\n" +
                        "<a href='http://localhost:8080/Recetario-1/recetario/recetas'>Obtiene Todas las Recetas</a>";
        return Response.status(Response.Status.OK).entity(mensaje).build();
    }

    @Override
    @POST
    @Path("/agrega")

    public Response agregaReceta(String _receta) {
        int encontro = 0;
        Jsonb jsonB = JsonbBuilder.create();
        Receta rt = jsonB.fromJson(_receta, Receta.class);

        for (Receta r : this.recetas) {
            encontro += (r.getIdReceta() == rt.getIdReceta()) ? 1 : 0;
        }
        if (encontro == 0 || this.recetas.isEmpty()) {
            this.recetas.add(rt);

            return Response.status(Response.Status.CREATED).entity(_receta).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity("La receta ya existe").build();
        }
    }

    @Override
    @GET
    @Path("/obtiene/{idR}")
    public Response obtieneReceta(@PathParam("idR") int idR) {
        Jsonb jsonB = JsonbBuilder.create();
        Response respuesta;
        int i = 0;
        if (this.recetas.isEmpty()) {
            String mensaje = "Recetario no contiene recetas en este momento";
            return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
        }

        i = buscaReceta(idR);


        String receta = (i >= 0) ? jsonB.toJson(recetas.get(i)) : null;
        respuesta = (receta == null) ?
                Response.status(Response.Status.NOT_FOUND).entity("No existe receta con esa identificacion").build() :
                Response.status(Response.Status.FOUND).entity(receta).build();

        return respuesta;
    }

    @Override
    @GET
    @Path("/obtienetipo/{idT}")
    public Response obtieneRecetasTipo(@PathParam("idT") int idT) {
        Jsonb jsonB = JsonbBuilder.create();
        ArrayList<Receta> rTipos = obtieneListaTipos(idT);
        String listaTipos = jsonB.toJson(rTipos);
        Response respuesta;
        int i = 0;
        if (this.recetas.isEmpty()) {
            String mensaje = "Recetario no contiene recetas en este momento";
            return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
        }

        i = buscaRecetaTipo(idT);


        //String receta = (i >= 0) ? jsonB.toJson(recetas.get(i)) : null;
        respuesta = (listaTipos == null) ?
                Response.status(Response.Status.NOT_FOUND).entity("No existe ese tipo de receta").build() :
                Response.status(Response.Status.FOUND).entity(listaTipos).build();

        return respuesta;
    }

    @Override
    @PUT
    @Path("/modifica/{idR}")
    public Response modificaReceta(@PathParam("idR") int idR, String receta) {
        Jsonb jsonB = JsonbBuilder.create();
        Response respuesta;
        Jsonb jsonReceta = JsonbBuilder.create();
        Receta rt = jsonReceta.fromJson(receta, Receta.class);

        int i = 0;
        if (this.recetas.isEmpty()) {
            String mensaje = "Recetario no contiene recetas en este momento";
            return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
        }

        i = buscaReceta(idR);

        if (i >= 0) {
            recetas.add(i, rt);
            respuesta = Response.status(Response.Status.FOUND).entity(receta).build();

        } else {

            respuesta = Response.status(Response.Status.NOT_FOUND).entity("No existe receta con esa identificacion").build();
        }

        return respuesta;
    }

    @PATCH
    @Path("/actualiza/{idT}/{idR}")
    public Response modificaReceta(@PathParam("idT")int idT,@PathParam("idR") int idR, String receta) {
        Jsonb jsonB = JsonbBuilder.create();
        Response respuesta = null;
        Jsonb jsonReceta = JsonbBuilder.create();
        Receta rt = jsonReceta.fromJson(receta, Receta.class);

        int i = 0;
        int j = 0;
        if (this.recetas.isEmpty()) {
            String mensaje = "Recetario no contiene recetas en este momento";
            return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
        }


        j= buscaRecetaTipo(idT);
        i=buscaRecetaTipo(idT,idR);

        if (j >= 0) {
            i = buscaReceta(idR);
            if(i>=0){
                recetas.add(i, rt);
                respuesta = Response.status(Response.Status.FOUND).entity(receta).build();
            }           

        } else {

            respuesta = Response.status(Response.Status.NOT_FOUND).entity("No existe ese tipo de receta esa identificacion").build();
        }

        return respuesta;
    }

    @Override
    @GET
    @Path("/recetas")

    public Response obtieneRecetas() {

        Jsonb jsonB = JsonbBuilder.create();
        String jsonListReceta = jsonB.toJson(this.recetas);

        if (this.recetas.isEmpty()) {
            String mensaje =
                    "<h1>No se encontraron recetas</h1>\n" +
                            "<p><a href='http://localhost:8080/Recetario-1/recetario/agrega'>Clic aqui para agregar recetas</a></p>";
            return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
        }

        return Response.status(Response.Status.OK).entity(jsonListReceta).build();
    }

    @Override
    public int buscaReceta(int i) {
        Receta _r[] = new Receta[recetas.size()];
        _r = recetas.toArray(_r);

        for (int j = 0; j < _r.length; j++) {

            if (_r[j].getIdReceta() == i) {

                return j;
            }
        }
        return -1;
    }

    @Override
    public int buscaRecetaTipo(int i) {
        Receta _r[] = new Receta[recetas.size()];
        _r = recetas.toArray(_r);

        for (int j = 0; j < _r.length; j++) {

            if (_r[j].getIdTipoReceta() == i) {

                return j;
            }
        }
        return -1;
    }
    public ArrayList<Receta> obtieneListaTipos(int i) {
        Receta _r[] = new Receta[recetas.size()];
        ArrayList<Receta> rtipos= new ArrayList<Receta>();
        _r = recetas.toArray(_r);

        for (int j = 0; j < _r.length; j++) {

            if (_r[j].getIdTipoReceta() == i) {
                rtipos.add(_r[j]);
            }


        }
        if(rtipos.isEmpty()){
            return null;
        }
        return new ArrayList<Receta>(rtipos);
    }

    public int buscaRecetaTipo(int it, int i) {
        Receta _r[] = new Receta[recetas.size()];
        _r = recetas.toArray(_r);
        ArrayList<Integer>indices= new ArrayList<Integer>();

        for (int j = 0; j < _r.length; j++) {

            if (_r[j].getIdTipoReceta() == it) {

                indices.add(j);
            }
        }
        for(int k : indices){
            if(recetas.get(k).getIdReceta()==i){
                return recetas.indexOf(recetas.get(k));
            }
        }

        return -1;
    }

  /*  @Override
    @PUT
    @Path("/agregarecetas")
    public Response agregaRecetas(JsonArray _recetas) {
        Jsonb jsonb = JsonbBuilder.create();
        List<Receta> r = jsonb.fromJson(
                _recetas,
                new ArrayList<Receta>(){}.getClass().getGenericSuperclass());

        return null;
    }*/
}
