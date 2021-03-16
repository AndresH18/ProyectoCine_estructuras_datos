package cine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import javax.swing.JFrame;

import cine.pelicula.Genero;
import cine.pelicula.Pelicula;
import cine.persona.Cliente;
import cine.persona.Empleado;
import cine.persona.Sexo;
import cine.sala.Sala;
import cine.sala.TipoSala;
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
		this.peliculas = new Pelicula[] { Pelicula.createDefault(),
				new Pelicula("DefaultID", "DefaultName", "origDef", Genero.ACCION, false) };
		this.salas = new Sala[] { Sala.createDefault(peliculas[0]), Sala.create2(peliculas[1]) };
		this.empleados = new Empleado[] { new Empleado("MiEmpleado", "Manuela", Sexo.FEMENINO) };

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

	public void comparBoleta(Cliente cliente, Sala sala, int fila, int columna) throws AsientoE, SalaNotFoundE {
		if (verifySala(sala)) {
			try {
				if (sala.asignarAsiento(cliente, fila, columna)) {
					ganancias += sala.getAsiento(fila, columna).getTipoAsiento().getPrecio();
					update();
				} else {
					throw new AsientoOcupadoE();
				}
			} catch (InvalidArgumentE e) {
				e.printStackTrace();
			}
		} else {
			throw new SalaNotFoundE();
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
				if (sala.reservarAsiento(cliente, fila, columna)) {
					update();
				} else {
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
			update();
		} else {
			throw new SalaNotFoundE();
		}
	}

	public void limpiarSala(Sala sala) throws SalaNotFoundE {
		if (verifySala(sala)) {
			sala.limpiarSala();
			update();
		} else {
			throw new SalaNotFoundE();
		}
	}

	public void establecerSala(Sala sala, Pelicula pelicula, TipoSala tipoSala) throws SalaNotFoundE {
		if (verifySala(sala)) {
			limpiarSala(sala);
			sala.setPelicula(pelicula);
			sala.setTipoSala(tipoSala);

			update();

		} else {
			throw new SalaNotFoundE();
		}

	}

	private boolean verifySala(Sala sala) {
		int n = -1;
		while (++n < salas.length && salas[n] != sala)
			;
		return n < salas.length;

	}

	public void update() {
		// UPDATE FICHERO
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA))) {
			out.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Pelicula buscarPelicula(String id) {
		int n = -1;
		while (++n < peliculas.length && !peliculas[n].getId().equalsIgnoreCase(id))
			;
		return n < peliculas.length ? peliculas[n] : null;

	}
	public void agregarPelicula(Pelicula pelicula) {
		peliculas = Arrays.copyOf(peliculas, peliculas.length + 1);
		peliculas[peliculas.length - 1] = pelicula;

		update();
	}

	public Empleado buscarEmpleado(String id) {
		int n = -1;
		while (++n < empleados.length && !empleados[n].getID().equalsIgnoreCase(id))
			;

		return n < empleados.length ? empleados[n] : null;
	}

	public void agregarEmpleado(Empleado empleado) {
		empleados = Arrays.copyOf(empleados, empleados.length + 1);
		empleados[empleados.length - 1] = empleado;

		update();
	}

	/**
	 * ELIMINA AL EMPLEADO, SI EXISTE, DEL ARREGLO DE EMPLEADOS
	 * 
	 * @param e EL EMPLEADO
	 */
	public void eliminarEmpleado(Empleado e) {
		int n = -1;
		while (++n < empleados.length && empleados[n] != e)
			;
		if (empleados.length - (n + 1) >= 0) {
			System.arraycopy(empleados, n + 1, empleados, n, empleados.length - (n + 1));
			empleados = Arrays.copyOf(empleados, empleados.length - 1);
			
		}
		update();
	}
	/**
	 * Este metodo es para agregar salas
	 * @param sala La sla
	 */
	public void agregarSala(Sala sala) {
		salas = Arrays.copyOf(salas, salas.length + 1);
		salas[salas.length - 1] = sala;

		update();
	}


	public Sala[] getSalas() {
		return salas;
	}

	public Pelicula[] getPeliculas() {
		return peliculas;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @deprecated
	 * @param id
	 * @param n
	 * @return
	 */
	public Pelicula buscarPelicula(String id, int n) {
		int i = 0;
		while (i < peliculas.length || peliculas[i].getId().compareToIgnoreCase(id) != 0)
			i++;
		if (i < peliculas.length) {
			return peliculas[i];
		}
		return null;
	}


	/**
	 * @deprecated
	 * @param id
	 * @return
	 */
	public Sala buscarSala(int id) {

		int i = 0;
		while (salas[i].getId() != id || i < salas.length)
			i++;
		if (i < salas.length) {
			return salas[i];
		}
		return null;
	}

	public double getGanancias() {
		return ganancias;
	}
	
	

}
