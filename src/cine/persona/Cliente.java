package cine.persona;

public class Cliente extends Persona {
    private int puntos;

    public Cliente(String id, String nombre, String direccion, int telefono, Sexo sexo) {
        super(id, nombre, direccion, telefono, sexo);
        this.puntos = 0;
    }

    public Cliente(String id, String nombre, String direccion, int telefono, Sexo sexo, int puntos) {
        super(id, nombre, direccion, telefono, sexo);
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public void addPuntos(int cantidad) {
        this.puntos += cantidad;
    }

}
