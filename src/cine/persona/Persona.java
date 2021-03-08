package cine.persona;

public class Persona {

    protected String id;
    protected String nombre;
    protected String dirección;
    protected int telefono;
    protected Sexo sexo;

    public Persona(String id, String nombre, String direccion, int telefono, Sexo sexo) {
        super();
        this.id = id;
        this.sexo = sexo;
        this.nombre = nombre;
        this.dirección = direccion;
        this.telefono = telefono;
    }


    public String getID() {
        return id;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
