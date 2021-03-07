package cine.sala.asiento;

public enum TipoAsiento {

    GENERAL(0),
    PREFERENCIAl(0),
    PLATINUM(0),
    GOLD(0),
    DISCAPACITADOS(0);

    private final double precio;

    TipoAsiento(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
