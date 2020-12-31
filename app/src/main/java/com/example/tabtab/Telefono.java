package com.example.tabtab;

public class Telefono {

    private String numero,nombre;

    public Telefono(String numero,String nombre){
        this.numero = numero;
        this.nombre = nombre;
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
