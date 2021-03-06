package cine.cafeteria;

public enum Producto {

    CRISPETAS(0),
    GASEOSA(0),
    DULCE(0),
    PERRO(0),
    NACHOS(0);

    private final double precio;

    Producto(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
