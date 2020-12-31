package com.example.tabtab;

public class Cancion {

    private String autor, nombreCancion,ruta,duracion;

    public Cancion(String autor, String nomCancion){
        this.autor = autor;
        this.nombreCancion = nomCancion;
    }
    public Cancion(String autor, String nomCancion, String duracion){
        this.autor = autor;
        this.nombreCancion = nomCancion;
        this.duracion = duracion;
    }

    public Cancion(String autor, String nomCancion, String ruta, String duracion){
        this.autor = autor;
        this.nombreCancion = nomCancion;
        this.duracion = duracion;
        this.ruta = ruta;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
