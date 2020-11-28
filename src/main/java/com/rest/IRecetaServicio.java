package com.rest;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IRecetaServicio {

    public Response agregaReceta(Receta _receta);
    public Response obtieneReceta(int idR);
    public Response obtieneRecetasTipo(int idT);
    public Response modificaReceta(int idR);


}
