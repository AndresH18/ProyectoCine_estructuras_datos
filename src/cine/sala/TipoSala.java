package cine.sala;

public enum TipoSala {

    NORMAL(0),
    D3(0),
    DX4(0),
    BLACK_STAR(0),
    SUPER_NOVA(0),
    CINE_ARTE(0),
    STAR_KIDS(0);

    public final double precio;

    TipoSala(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
