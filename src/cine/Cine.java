package cine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;

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

//	private static final File ROOT = new File(System.getProperty("user.dir").concat("\\Data"));
//	private static File DATA = new File(ROOT, "cine.cn");
	private final File DATA;

//	public Cine(String s) {
//		if (!(ROOT.exists() && ROOT.isDirectory())) {
//			ROOT.mkdirs();
//		}
//		this.ganancias = 0;
//
//		// TODO FIXME: Leer Fichero para inicializar datos
//		this.peliculas = new Pelicula[0];
//		this.salas = new Sala[0];
//		this.clientes = new Cliente[0];
//		this.empleados = new Empleado[0];
////		if(!ROOT.exists() || !ROOT.isDirectory()) {
////		if(!(ROOT.exists() && ROOT.isDirectory()){
//	}

	public Cine(File dataFile) {
		this.DATA = dataFile;
		this.ganancias = 0;
		this.peliculas = new Pelicula[] { Pelicula.createDefault() };
		this.salas = new Sala[] { Sala.createDefault() };
		this.clientes = new Cliente[0];
		this.empleados = new Empleado[0];

		update();

//		System.out.println(ROOT.getAbsolutePath());
//		if (!(ROOT.exists() && ROOT.isDirectory())) {
//			ROOT.mkdirs();
//			// DEFAULT VALUES FOR NON EXISTENT FILE
//			this.ganancias = 0;
////			this.peliculas = new Pelicula[0];
//			this.peliculas = new Pelicula[] { Pelicula.createDefault() };
//			this.salas = new Sala[] { Sala.createDefault() };
//			this.clientes = new Cliente[0];
//			this.empleados = new Empleado[0];
//		} else if (DATA.exists()) {
//
//		}

	}

//	public Cine(int opt, File cineFile) {
//		this.DATA = cineFile;
//		if (opt == 0) {
//			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA))) {
//				
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

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

			update();

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

	public void update() {
		// TODO: UPDATE FICHERO
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA))) {
			out.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Empleado buscarEmpleado(String id) {
		int n = -1;
		while (++n < empleados.length && !empleados[n].getID().equalsIgnoreCase(id))
			;

		return n < empleados.length ? empleados[n] : null;
	}

	public Sala[] getSalas() {
		return salas;
	}

	public Pelicula[] getPeliculas() {
		return peliculas;
	}

}
