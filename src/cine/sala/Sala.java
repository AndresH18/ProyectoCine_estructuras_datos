package cine.sala;

import java.io.Serializable;

import cine.pelicula.Genero;
import cine.pelicula.Pelicula;
import cine.persona.Cliente;
import cine.sala.asiento.Asiento;
import cine.sala.asiento.EstadoAsiento;
import cine.sala.asiento.TipoAsiento;
import exceptions.*;

public class Sala implements Serializable {

	private static int numSalas = 0;
	private final int id;
	private final Asiento[][] asientos;

	private Pelicula pelicula;
	private TipoSala tipoSala;

	public Sala(Pelicula pelicula, TipoSala tipoSala, int filas, int columnas) {
		this.id = ++numSalas;
		this.pelicula = pelicula;
		this.tipoSala = tipoSala;
		this.asientos = new Asiento[filas][columnas];

		fillAsientos();

	}

	private Sala(TipoSala tipoSala, int filas, int columnas) {
		this.id = ++numSalas;
		this.pelicula = null;
		this.tipoSala = tipoSala;
		this.asientos = new Asiento[filas][columnas];

		fillAsientos();

	}

	private Sala(Pelicula p, String s) {
		this.id = 100;
		this.pelicula = p;
		this.tipoSala = TipoSala.BLACK_STAR;
		this.asientos = new Asiento[][] {
				{ new Asiento(EstadoAsiento.OCUPADO, TipoAsiento.PREFERENCIAL),
						new Asiento(EstadoAsiento.OCUPADO, TipoAsiento.PREFERENCIAL) },
				{ new Asiento(EstadoAsiento.OCUPADO, TipoAsiento.PREFERENCIAL),
						new Asiento(EstadoAsiento.OCUPADO, TipoAsiento.PREFERENCIAL) } };

	}

	private Sala(Pelicula p) {
		this.id = 9000;
		this.pelicula = p;
		this.tipoSala = TipoSala.DX4;
		this.asientos = new Asiento[][] {
				{ new Asiento(EstadoAsiento.OCUPADO, TipoAsiento.PLATINUM),
						new Asiento(EstadoAsiento.RESERVADO, TipoAsiento.GOLD),
						new Asiento(EstadoAsiento.OCUPADO, TipoAsiento.GENERAL) },
				{ new Asiento(EstadoAsiento.RESERVADO, TipoAsiento.GOLD),
						new Asiento(EstadoAsiento.RESERVADO, TipoAsiento.GOLD),
						new Asiento(EstadoAsiento.OCUPADO, TipoAsiento.GENERAL) },
				{ new Asiento(EstadoAsiento.DISPONIBLE, TipoAsiento.PLATINUM),
						new Asiento(EstadoAsiento.RESERVADO, TipoAsiento.GOLD),
						new Asiento(EstadoAsiento.OCUPADO, TipoAsiento.GENERAL) } };
	}

	public boolean asignarAsiento(Cliente cliente, int fila, int columna) throws InvalidArgumentE {

		if ((fila >= asientos.length || fila < 0) && (columna >= asientos[0].length || columna < 0)) {
			throw new InvalidArgumentE("LA POSICION [" + fila + " , " + columna + "] NO ES VALIDA");

		} else if (fila >= asientos.length || fila < 0) {
			throw new InvalidRowArgumentE(fila);

		} else if (columna >= asientos[0].length || columna < 0) {
			throw new InvalidColumnArgumentE(columna);
		}

		if ((asientos[fila][columna].getEstadoAsiento() == EstadoAsiento.DISPONIBLE)
				|| (asientos[fila][columna].getEstadoAsiento() == EstadoAsiento.RESERVADO
						&& asientos[fila][columna].getCliente() == cliente)) {
			
			asientos[fila][columna].setEstadoAsiento(EstadoAsiento.OCUPADO);
			asientos[fila][columna].setCliente(cliente);
			
			return true;

//		} else if (asientos[fila][columna].getEstadoAsiento() == EstadoAsiento.RESERVADO
//				&& asientos[fila][columna].getCliente() == cliente) {
//			
//			asientos[fila][columna].setEstadoAsiento(EstadoAsiento.OCUPADO);
//			asientos[fila][columna].setCliente(cliente);
//			return true;
//		} else {
		} else {
			return false;
		}
	}

	public boolean reservarAsiento(Cliente cliente, int fila, int columna) throws InvalidArgumentE {
		if ((fila >= asientos.length || fila < 0) && (columna >= asientos[0].length || columna < 0)) {
			throw new InvalidArgumentE("LA POSICION [" + fila + " , " + columna + "] NO ES VALIDA");

		} else if (fila >= asientos.length || fila < 0) {
			throw new InvalidRowArgumentE(fila);

		} else if (columna >= asientos[0].length || columna < 0) {
			throw new InvalidColumnArgumentE(columna);
		}

		if (asientos[fila][columna].getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
			asientos[fila][columna].setEstadoAsiento(EstadoAsiento.RESERVADO);
			asientos[fila][columna].setCliente(cliente);
			return true;

		} else {
			return false;
		}

	}

	public void liberarAsiento(int fila, int columna) throws InvalidArgumentE {
		if ((fila >= asientos.length || fila < 0) && (columna >= asientos[0].length || columna < 0)) {
			throw new InvalidArgumentE("LA POSICION [" + fila + " , " + columna + "] NO ES VALIDA");

		} else if (fila >= asientos.length || fila < 0) {
			throw new InvalidRowArgumentE(fila);

		} else if (columna >= asientos[0].length || columna < 0) {
			throw new InvalidColumnArgumentE(columna);

		}

		asientos[fila][columna].setEstadoAsiento(EstadoAsiento.DISPONIBLE);
		asientos[fila][columna].setCliente(null);

	}

	private void fillAsientos() {
		// 00% - 40% General
		// 40% - 60% Preferencial
		// 60% - 80% Platinum
		// 80% - 100% Gold
		final int filas = asientos.length;
		final int general = (int) Math.round(filas * 0.4);
		final int preferencial = (int) Math.round(filas * 0.6);
		final int platinum = (int) Math.round(filas * 0.8);
//        final int gold = (int) Math.round(filas);

		for (int i = 0; i < asientos.length; i++) {
			TipoAsiento tiAsiento;

			if (i < general) {
//                Arrays.fill(asientos[i], Asiento.crearAsientoDisponible(TipoAsiento.GENERAL));
				tiAsiento = TipoAsiento.GENERAL;

			} else if (general <= i && i < preferencial) {
				// i < preferencial
//                Arrays.fill(asientos[i], Asiento.crearAsientoDisponible(TipoAsiento.PREFERENCIAl));
				tiAsiento = TipoAsiento.PREFERENCIAL;

			} else if (preferencial <= i && i < platinum) {
				// i < platinum
//                Arrays.fill(asientos[i], Asiento.crearAsientoDisponible(TipoAsiento.PLATINUM));
				tiAsiento = TipoAsiento.PLATINUM;

			} else {
//                Arrays.fill(asientos[i], Asiento.crearAsientoDisponible(TipoAsiento.GOLD));
				tiAsiento = TipoAsiento.GOLD;

			}

			for (int j = 0; j < asientos[i].length; j++) {
				asientos[i][j] = Asiento.crearAsientoDisponible(tiAsiento);
			}
		}
	}

//	private String mostrarSala() {
//		StringBuilder sb = new StringBuilder();
//
//		for (Asiento[] asiento : asientos) {
//			for (Asiento value : asiento) {
//				sb.append("[").append(value.getEstadoAsiento()).append("]");
//			}
//			sb.append("\n");
//		}
//		return sb.toString();
//	}

	public void limpiarSala() {
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				try {
					liberarAsiento(i, j);
				} catch (InvalidArgumentE invalidArgumentE) {
					// FIXME:
					invalidArgumentE.printStackTrace();
				}
			}
		}
	}

	public Asiento getAsiento(int fila, int columna) throws InvalidArgumentE {
		if ((fila >= asientos.length || fila < 0) && (columna >= asientos[0].length || columna < 0)) {
			throw new InvalidArgumentE("LA POSICION [" + fila + " , " + columna + "] NO ES VALIDA");

		} else if (fila >= asientos.length || fila < 0) {
			throw new InvalidRowArgumentE(fila);

		} else if (columna >= asientos[0].length || columna < 0) {
			throw new InvalidColumnArgumentE(columna);
		}

		return asientos[fila][columna];
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public TipoSala getTipoSala() {
		return tipoSala;
	}

	public void setPelicula(Pelicula pelicula) {
		limpiarSala();
		this.pelicula = pelicula;
	}

	public void setTipoSala(TipoSala tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getId() {
		return id;
	}

	public Asiento[][] getAsientos() {
		return asientos;
	}

	public static Sala createDefault(Pelicula p) {
		return new Sala(p, null);
	}

	public static Sala create2(Pelicula p) {
		return new Sala(p);
	}
}
