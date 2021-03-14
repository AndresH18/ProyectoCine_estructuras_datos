package cine.persona;

import java.io.Serializable;

public class Persona implements Serializable{

    protected String id;
    protected String nombre;
    protected String direccion;
    protected int telefono;
    protected Sexo sexo;

    public Persona(String id, String nombre, Sexo sexo) {
        super();
        this.id = id;
        this.sexo = sexo;
        this.nombre = nombre;
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
