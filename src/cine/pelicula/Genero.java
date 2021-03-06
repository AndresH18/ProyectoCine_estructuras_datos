package cine.pelicula;

public enum Genero {

    ACCION(0),
    TERROR(0),
    AVENTURA(0),
    COMEDIA(0),
    DRAMA(0),
    CIENCA_FICCION(0),
    WEST(0),
    SUSPENSO(0),
    MUSICAL(0),
    DOCUMENTAL(0);

    private final int edadRecomendada;

    Genero(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }
}
