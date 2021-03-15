package cine.pelicula;

import java.io.Serializable;

public class Pelicula implements Serializable {

	private String id;
	private String nombre;
	private String nombreOriginal;
	private Genero genero;
	private boolean doblaje;

	public Pelicula(String idPelicula, String nombre, String nombreOriginal, Genero genero, boolean doblaje) {
		this.id = idPelicula;
		this.nombre = nombre;
		this.nombreOriginal = nombreOriginal;
		this.doblaje = doblaje;
		this.genero = genero;
	}

	private Pelicula() {
		this.id = "DEFAULT";
		this.nombre = "DEFAULT";
		this.nombreOriginal = "DEFAULT";
		this.doblaje = false;
		this.genero = Genero.ACCION;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNombreOriginal() {
		return nombreOriginal;
	}

	public boolean isDoblaje() {
		return doblaje;
	}

	public Genero getGenero() {
		return genero;
	}

//	public static Pelicula createDefault() {
//		return new Pelicula("DEFAULT","DEFAULT","DEFAULT",Genero.ACCION, false);
//	}
	public static Pelicula createDefault() {
		return new Pelicula();
	}

	@Override
	public String toString() {
		return ("[\tID: " + id + "\n" + "\tNombre: " + nombre + "\n" + "\tNombre Original: " + nombreOriginal + "\n"
				+ "\tGenero: " + genero.toString() + "\n" + "\tdoblaje: " + doblaje + "]").replaceAll("\t", "    ")
						.replaceAll("\n", "<br>");
	}

}