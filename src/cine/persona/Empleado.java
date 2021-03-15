package cine.persona;

public class Empleado extends Persona {

    private static int numEmlpeados = 0;
    private int idEmpleado;

    public Empleado(String id, String nombre, Sexo sexo) {
        super(id, nombre, sexo);
        this.idEmpleado = ++numEmlpeados;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

}
