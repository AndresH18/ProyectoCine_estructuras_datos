package cine;

import cine.pelicula.Pelicula;
import cine.persona.Cliente;
import cine.persona.Empleado;
import cine.sala.Sala;
import cine.sala.asiento.Asiento;
import cine.sala.asiento.EstadoAsiento;

public class Cine {

	private Pelicula[] peliculas;
	private Sala[] salas;
	private Empleado[] empleados;
	private Cliente[] clientes;
	private double ganancias;

	public Cine() {
		this.ganancias = 0;
		
		// TODO FIXME: Leer Fichero para inicializar datos
		this.peliculas = new Pelicula[0];
		this.salas = new Sala[0];
		this.clientes = new Cliente[0];
		this.empleados = new Empleado[0];
	}

	public void comparBoleta(Sala sala, int fila, int columna) {
		
		final Asiento asiento = sala.getAsiento(fila, columna);
		
		if (asiento.getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
			asiento.setEstadoAsiento(EstadoAsiento.OCUPADO);
			ganancias += asiento.getTipoAsiento().getPrecio();
		}

	}

	public boolean reservar(Sala sala, int fila, int columna) {
		return sala.reservarAsiento(fila, columna);
	}

	public void liberarAsiento(Sala sala, int fila, int columna) {
		sala.liberarAsiento(fila, columna);
	}

}
