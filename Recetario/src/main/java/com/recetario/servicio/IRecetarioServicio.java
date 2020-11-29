package com.recetario.servicio;


import com.recetario.modelo.Receta;

import javax.ws.rs.core.Response;

public interface IRecetarioServicio {

    public Response agregaReceta(String _receta);
    public Response obtieneReceta(int idR);
    public Response obtieneRecetasTipo(int idT);
    public Response modificaReceta(int idR);
    public Response obtieneRecetas();


}