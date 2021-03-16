package cine.sala.asiento;

public enum TipoAsiento {

    GENERAL(10_000),
    PREFERENCIAL(15_000),
    PLATINUM(20_000),
    GOLD(30_000),
    DISCAPACITADOS(7_000);

    private final double precio;

    TipoAsiento(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
