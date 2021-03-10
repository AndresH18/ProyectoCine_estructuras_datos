package cine.persona;

import java.io.Serializable;

public class Persona implements Serializable{

    protected String id;
    protected String nombre;
    protected String direccion;
    protected int telefono;
    protected Sexo sexo;

    public Persona(String id, String nombre, String direccion, int telefono, Sexo sexo) {
        super();
        this.id = id;
        this.sexo = sexo;
        this.nombre = nombre;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setDireccionn(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
