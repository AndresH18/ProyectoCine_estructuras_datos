package cine.persona;

public class Empleado extends Persona {

    private static int numEmlpeados = 0;
    private int idEmpleado;

    public Empleado(String id, String nombre, String direccion, int telefono, Sexo sexo) {
        super(id, nombre, direccion, telefono, sexo);
        this.idEmpleado = ++numEmlpeados;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

}
