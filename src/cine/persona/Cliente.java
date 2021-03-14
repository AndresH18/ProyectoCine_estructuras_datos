package cine.persona;

public class Cliente extends Persona {
	
    private int puntos;

    public Cliente(String id, String nombre, Sexo sexo) {
        super(id, nombre,  sexo);
        this.puntos = 0;
    }

    public Cliente(String id, String nombre, Sexo sexo, int puntos) {
        super(id, nombre, sexo);
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
