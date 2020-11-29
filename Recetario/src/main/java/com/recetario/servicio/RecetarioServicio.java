package com.recetario.servicio;

import com.recetario.*;
import com.recetario.modelo.Receta;

import javax.json.Json;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregaReceta(String _receta) {
        int encontro = 0;
        Jsonb jsonB = JsonbBuilder.create();
        Receta rt = jsonB.fromJson(_receta,Receta.class);

        for (Receta r : this.recetas) {
            encontro+= (r.getIdReceta() == rt.getIdReceta())? 1 : 0;
        }
        if (encontro !=0 || this.recetas.isEmpty()) {
            this.recetas.add(rt);

            return Response.status(Response.Status.CREATED).entity(_receta).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity("La receta ya existe").build();
        }
    }

    @Override
    public Response obtieneReceta(int idR) {
        return null;
    }

    @Override
    public Response obtieneRecetasTipo(int idT) {
        return null;
    }

    @Override
    public Response modificaReceta(int idR) {
        return null;
    }

    @Override
    @GET
    @Path("/recetas")
    //@Produces(MediaType.MEDIA_TYPE_WILDCARD)
    @Produces(MediaType.TEXT_HTML)
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
}
