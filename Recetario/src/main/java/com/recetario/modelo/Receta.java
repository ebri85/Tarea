package com.recetario.modelo;


public class Receta {

    private int idReceta;
    private int idTipoReceta;
    private String descripcion;
    private boolean disponible;

    public Receta() {

    }

    public Receta(int idReceta, int idTipoReceta, String descripcion, boolean disponible) {
        this.idReceta = idReceta;
        this.idTipoReceta = idTipoReceta;
        this.descripcion = descripcion;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "idReceta=" + idReceta +
                ", idTipoReceta=" + idTipoReceta +
                ", descripcion='" + descripcion + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}

