package cine.sala;

public enum TipoSala {

    NORMAL(0),
    D3(4_000),
    DX4(6_000),
    BLACK_STAR(8_000),
    SUPER_NOVA(10_000),
    CINE_ARTE(4_000),
    STAR_KIDS(50_000);

    public final double precio;

    TipoSala(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
