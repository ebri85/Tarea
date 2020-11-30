package com.recetario.servicio;


import com.recetario.modelo.Receta;

import javax.json.JsonArray;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public interface IRecetarioServicio {

    public Response agregaReceta(String _receta);
    public Response obtieneReceta(int idR);
    public Response obtieneRecetasTipo(int idT);
    public Response modificaReceta(int idR, String receta);
    public Response obtieneRecetas();
    //public Response agregaRecetas(JsonArray _recetas);
    public int buscaReceta(int i);
    public int buscaRecetaTipo(int i);

}