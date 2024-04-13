package org.example;

public class PlayList
{
    NODO primero;
    NODO ultimo;
    int tamano;

    public PlayList()
    {
        primero = null;
        ultimo = null;
        tamano = 0;
    }

    public void agregarCancion(String nombre, String artista, String genero, int duracion)
    {
        NODO nuevo = new NODO(nombre, artista, genero, duracion);
        if(primero == null)
        {
            primero = nuevo;
            ultimo = nuevo;
        }
        else
        {
            ultimo.enlace = nuevo;
            ultimo = nuevo;
        }
        tamano++;
    }

    public void visualizar()
    {
        NODO aux = primero;
        while(aux != null)
        {
            //convertir tiempo de segundos a minutos y segundos
            int minutos = aux.duracion / 60;
            int segundos = aux.duracion % 60;

            System.out.println("Nombre: " + aux.nombre);
            System.out.println("Artista: " + aux.artista);
            System.out.println("Genero: " + aux.genero);
            System.out.println("Duracion: " + minutos + " minutos y " + segundos + " segundos");
            System.out.println("-------------------------------");
            aux = aux.enlace;
        }

        //Calcular duracion total de la playlisst en minutos y segundos
        int duracionTotal = 0;
        aux = primero;
        while(aux != null)
        {
            duracionTotal += aux.duracion;
            aux = aux.enlace;
        }
        int minutos = duracionTotal / 60;
        int segundos = duracionTotal % 60;
        System.out.println("Duracion total de la playlist: " + minutos + " minutos y " + segundos + " segundos");
    }

    public void eliminarCancion(String nombre)
    {
        NODO aux = primero;
        NODO anterior = null;
        while(aux != null)
        {
            if(aux.nombre.equals(nombre))
            {
                if(aux == primero)
                {
                    primero = primero.enlace;
                }
                else if(aux == ultimo)
                {
                    anterior.enlace = null;
                    ultimo = anterior;
                }
                else
                {
                    anterior.enlace = aux.enlace;
                }
                tamano--;
            }
            anterior = aux;
            aux = aux.enlace;
        }
    }

    public void buscarCancion(String nombre)
    {
        NODO aux = primero;
        while(aux != null)
        {
            if(aux.nombre.equals(nombre))
            {
                System.out.println("Nombre: " + aux.nombre);
                System.out.println("Artista: " + aux.artista);
                System.out.println("Genero: " + aux.genero);
                System.out.println("Duracion: " + aux.duracion);
                System.out.println("-------------------------------");
            }
            aux = aux.enlace;
        }
    }

    public void modificarCancion(String nombre, String artista, String genero, int duracion)
    {
        NODO aux = primero;

        while(aux != null)
        {
            if(aux.nombre.equals(nombre))
            {
                aux.artista = artista;
                aux.genero = genero;
                aux.duracion = duracion;
            }
            aux = aux.enlace;
        }

    }

    public void ordenarPorGenero()
    {
        NODO aux = primero;
        NODO aux2 = null;
        while(aux != null)
        {
            aux2 = aux.enlace;
            while(aux2 != null)
            {
                if(aux.genero.compareTo(aux2.genero) > 0)
                {
                    String nombre = aux.nombre;
                    String artista = aux.artista;
                    String genero = aux.genero;
                    int duracion = aux.duracion;

                    aux.nombre = aux2.nombre;
                    aux.artista = aux2.artista;
                    aux.genero = aux2.genero;
                    aux.duracion = aux2.duracion;

                    aux2.nombre = nombre;
                    aux2.artista = artista;
                    aux2.genero = genero;
                    aux2.duracion = duracion;
                }
                aux2 = aux2.enlace;
            }
            aux = aux.enlace;
        }
    }
    public void menu()
    {
        int opcion;
        do
        {
            System.out.println("1. Agregar cancion");
            System.out.println("2. Visualizar canciones");
            System.out.println("3. Eliminar cancion");
            System.out.println("4. Buscar cancion");
            System.out.println("5. Modificar cancion");
            System.out.println("6. Ordenar canciones por genero");
            opcion = new java.util.Scanner(System.in).nextInt();
            switch(opcion)
            {
                case 1:
                    System.out.println("Ingrese nombre de la cancion");
                    String nombre = new java.util.Scanner(System.in).nextLine();
                    System.out.println("Ingrese nombre del artista");
                    String artista = new java.util.Scanner(System.in).nextLine();
                    System.out.println("Ingrese genero de la cancion");
                    String genero = new java.util.Scanner(System.in).nextLine();
                    System.out.println("Ingrese duracion de la cancion");
                    int duracion = new java.util.Scanner(System.in).nextInt();
                    agregarCancion(nombre, artista, genero, duracion);
                    break;
                case 2:
                    visualizar();
                    break;
                case 3:
                    System.out.println("Ingrese nombre de la cancion a eliminar");
                    String nombreEliminar = new java.util.Scanner(System.in).nextLine();
                    eliminarCancion(nombreEliminar);
                    break;
                case 4:
                    System.out.println("Ingrese nombre de la cancion a buscar");
                    String nombreBuscar = new java.util.Scanner(System.in).nextLine();
                    buscarCancion(nombreBuscar);
                    break;
                case 5:
                    System.out.println("Ingrese nombre de la cancion a modificar");
                    String nombreModificar = new java.util.Scanner(System.in).nextLine();
                    System.out.println("Ingrese nombre del artista");
                    String artistaModificar = new java.util.Scanner(System.in).nextLine();
                    System.out.println("Ingrese genero de la cancion");
                    String generoModificar = new java.util.Scanner(System.in).nextLine();
                    System.out.println("Ingrese duracion de la cancion");
                    int duracionModificar = new java.util.Scanner(System.in).nextInt();
                    modificarCancion(nombreModificar, artistaModificar, generoModificar, duracionModificar);
                    break;

                case 6:
                    ordenarPorGenero();
                    break;



            }
        }while(opcion != 7);
    }
}
