package com.recetario.modelo;


import java.util.Arrays;
import java.util.List;

public class Receta {

    private int idReceta;
    private int idTipoReceta;
    private String descripcion;
    private boolean disponible;
    private String[] ingredientes;

    public Receta() {

    }

    public Receta(int idReceta, int idTipoReceta, String descripcion, boolean disponible,String[] ingredientes) {
        this.idReceta = idReceta;
        this.idTipoReceta = idTipoReceta;
        this.descripcion = descripcion;
        this.disponible = disponible;
        this.ingredientes = ingredientes;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "idReceta=" + idReceta +
                ", idTipoReceta=" + idTipoReceta +
                ", descripcion='" + descripcion + '\'' +
                ", disponible=" + disponible +
                ", ingredientes=" + Arrays.toString(ingredientes) +
                '}';
    }
}

