package cine.persona;

import java.io.Serializable;

public class Persona implements Serializable{

    protected String id;
    protected String nombre;
    protected Sexo sexo;

    public Persona(String id, String nombre, Sexo sexo) {
        super();
        this.id = id;
        this.sexo = sexo;
        this.nombre = nombre;
    }

    public Persona(String id) {
    	this.id = id;
    	this.nombre = null;
    	this.sexo = Sexo.INDEFINIDO;
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

}
