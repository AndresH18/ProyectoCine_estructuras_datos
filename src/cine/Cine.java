package cine;

import java.io.Serializable;

import cine.pelicula.Pelicula;
import cine.persona.Cliente;
import cine.persona.Empleado;
import cine.sala.Sala;
import cine.sala.asiento.Asiento;
import cine.sala.asiento.EstadoAsiento;
import exceptions.AsientoE;
import exceptions.AsientoOcupadoE;
import exceptions.InvalidArgumentE;
import exceptions.SalaNotFoundE;

public class Cine implements Serializable {

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

	public void comparBoleta(Cliente cliente, Sala sala, int fila, int columna) throws AsientoE {

		try {
			if (sala.asignarAsiento(cliente, fila, columna)) {
				ganancias += sala.getAsiento(fila, columna).getTipoAsiento().getPrecio();
			} else {
				throw new AsientoOcupadoE();
			}
		} catch (InvalidArgumentE e) {
			e.printStackTrace();
		}

//		try {
//			final Asiento asiento = sala.getAsiento(fila, columna);
//			
//			if (asiento.getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
//				asiento.setEstadoAsiento(EstadoAsiento.OCUPADO);
//				ganancias += asiento.getTipoAsiento().getPrecio();
//			}
//		} catch (InvalidArgumentE e) {
//			e.printStackTrace();
//		}

	}

	public void reservar(Cliente cliente, Sala sala, int fila, int columna) throws AsientoE, SalaNotFoundE {
		if (verifySala(sala)) {
			try {
				if (!sala.reservarAsiento(cliente, fila, columna)) {
					throw new AsientoOcupadoE();
				}
			} catch (InvalidArgumentE e) {
				e.printStackTrace();

			}
		} else {
			throw new SalaNotFoundE();
		}
	}

	public void liberarAsiento(Sala sala, int fila, int columna) throws InvalidArgumentE, SalaNotFoundE {
		if (verifySala(sala)) {
			sala.liberarAsiento(fila, columna);
		} else {
			throw new SalaNotFoundE();
		}
	}

	public void limpiarSala(Sala sala) throws SalaNotFoundE {
		if (verifySala(sala)) {
			sala.limpiarSala();
		} else {
			throw new SalaNotFoundE();
		}
	}

	public void establecerSala(Sala sala, Pelicula pelicula) throws SalaNotFoundE {
		if (verifySala(sala)) {
			limpiarSala(sala);
			sala.setPelicula(pelicula);
			
			 updateSalaRoot();
			 
		} else {
			throw new SalaNotFoundE();
		}

	}

	public boolean verifySala(Sala sala) {
		int n = -1;
		while (++n < salas.length && salas[n] != sala)
			;
		
		return n < salas.length;
	}
	
	public void updateSalaRoot() {
		//TODO
	}
	
	

	public Sala[] getSalas() {
		return salas;
	}
	
	
	

}
