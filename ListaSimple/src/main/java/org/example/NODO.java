package org.example;

public class NODO
{
    String nombre; String artista; String genero; int duracion; NODO enlace;

    public NODO(String nombre, String artista, String genero, int duracion)
    {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.enlace = null;
    }


}
