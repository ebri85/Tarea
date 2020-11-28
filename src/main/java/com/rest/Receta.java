package com.rest;



import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName(value = "receta")
public class Receta {

    private int idReceta;
    private int idTipoReceta;
    private String descripcion;
    private List<String> ingredientes;
    private boolean disponible;

    public Receta() {
    }

    public Receta(int idReceta, int idTipoReceta, String descripcion, List<String> ingredientes, boolean disponible) {
        this.idReceta = idReceta;
        this.idTipoReceta = idTipoReceta;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.disponible = disponible;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getIdTipoReceta() {
        return idTipoReceta;
    }

    public void setIdTipoReceta(int idTipoReceta) {
        this.idTipoReceta = idTipoReceta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "idReceta:" + idReceta +"\n"+
                "idTipoReceta:" + idTipoReceta +"\n"+
                "descripcion:" + descripcion + "\n"+
                "ingredientes:" + ingredientes +"\n" +
                "disponible:" + disponible +"\n"+
                '}';
    }
}



