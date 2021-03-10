package cine.pelicula;

public class Pelicula {

    private String id;
    private String nombre;
    private String nombreOriginal;
    private Genero genero;
    private boolean doblaje;

    public Pelicula(String idPelicula, String nombre, String nombreOriginal, Genero genero, boolean doblaje) {
        this.id = idPelicula;
        this.nombre = nombre;
        this.nombreOriginal = nombreOriginal;
        this.doblaje = doblaje;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreOriginal() {
        return nombreOriginal;
    }

    public boolean isDoblaje() {
        return doblaje;
    }

    public Genero getGenero() {
        return genero;
    }
}