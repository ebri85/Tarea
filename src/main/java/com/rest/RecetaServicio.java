package com.rest;


import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class RecetaServicio {

    private List<Receta> recetas = new ArrayList<Receta>();

    public List<Receta> obtieneRecetas() {
        List<Receta> _recetas = new ArrayList<Receta>();
        for (Receta receta : this.recetas) {
            _recetas.add(receta);
        }

        return _recetas;
    }

    public Receta obtieneTipoReceta(int tipoReceta) {
        for (Receta r : this.recetas) {
            if (r.getIdTipoReceta()== tipoReceta){
                return r;
            }
        }
        return null;
    }

    public String agregaReceta(Receta receta) {

        for (Receta r : this.recetas) {
            if (r.getIdReceta()==receta.getIdReceta()) {

                recetas.add(receta);
                return receta.toString();
            }
        }
        return null;
    }

    public String actualizaReceta(int id, Receta receta) {
        int i=0;
        for (Receta r : this.recetas) {
            if (r.getIdReceta()== id){
                i= this.recetas.indexOf(this.recetas);
                this.recetas.remove(i);
                this.recetas.add(i,receta);

                return receta.toString();
            }
        }
        return null;
    }
}
