package com.example.lunagonzalez.login;

/**
 * Created by Luna Gonzalez on 15/06/2016.
 */
public class Receta {

    public String nombre;
    public String ingredientes;
    public String preparacion;
    public String url;
    public int precio;

    public Receta(String nombre, String ingredientes,String preparacion, String url, int precio) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.url = url;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public String getUrl() {
        return url;
    }

    public int getPrecio() {
        return precio;
    }
}
