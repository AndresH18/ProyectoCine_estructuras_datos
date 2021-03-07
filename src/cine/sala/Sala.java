package cine.sala;

import cine.pelicula.Pelicula;
import cine.sala.asiento.Asiento;
import cine.sala.asiento.EstadoAsiento;
import cine.sala.asiento.TipoAsiento;
import exceptions.InvalidArgumentE;

import java.util.Arrays;

/**
 * Yay
 */
public class Sala {

    private final Asiento[][] asientos;
    private Pelicula pelicula;
    private TipoSala tipoSala;

    public Sala(Pelicula pelicula, TipoSala tipoSala, int filas, int columnas) {
        this.pelicula = pelicula;
        this.tipoSala = tipoSala;
        this.asientos = new Asiento[filas][columnas];

        fillAsientos();

    }

    public boolean asignarAsiento(int fila, int columna) throws InvalidArgumentE {
        if (fila >= asientos.length || fila < 0) {
            throw new InvalidArgumentE("LA FILA NO ES VALIDA");
        } else if (columna >= asientos[0].length || columna < 0) {
            throw new InvalidArgumentE("LA COLUMNA NO ES VALIDA");
        }

        if (asientos[fila][columna].getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
            asientos[fila][columna].setEstadoAsiento(EstadoAsiento.OCUPADO);
            return true;
        } else {
            return false;
        }
    }

    public boolean reservarAsiento(int fila, int columna) throws InvalidArgumentE {
        if (fila >= asientos.length || fila < 0) {
            throw new InvalidArgumentE("LA FILA NO ES VALIDA");
        } else if (columna >= asientos[0].length || columna < 0) {
            throw new InvalidArgumentE("LA COLUMNA NO ES VALIDA");
        }

        if (asientos[fila][columna].getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
            asientos[fila][columna].setEstadoAsiento(EstadoAsiento.RESERVADO);
            return true;
        } else {
            return false;
        }

    }

    public void liberarAsiento(int fila, int columna) throws InvalidArgumentE {
        if (fila >= asientos.length || fila < 0) {
            throw new InvalidArgumentE("LA FILA NO ES VALIDA");
        } else if (columna >= asientos[0].length || columna < 0) {
            throw new InvalidArgumentE("LA COLUMNA NO ES VALIDA");
        }

        asientos[fila][columna].setEstadoAsiento(EstadoAsiento.DISPONIBLE);

    }

    private void fillAsientos() {
        //00% - 40% General
        //40% - 60% Preferencial
        //60% - 80% Platinum
        //80% - 100% Gold
        final int filas = asientos.length;
        final int general = (int) Math.round(filas * 0.4);
        final int preferencial = (int) Math.round(filas * 0.6);
        final int platinum = (int) Math.round(filas * 0.8);
//        final int gold = (int) Math.round(filas);

        for (int i = 0; i < asientos.length; i++) {
            if (i < general) {
                Arrays.fill(asientos[i], Asiento.crearAsientoDisponible(TipoAsiento.GENERAL));
            } else if (general <= i && i < preferencial) {
                // i < preferencial
                Arrays.fill(asientos[i], Asiento.crearAsientoDisponible(TipoAsiento.PREFERENCIAl));
            } else if (preferencial <= i && i < platinum) {
                // i < platinum
                Arrays.fill(asientos[i], Asiento.crearAsientoDisponible(TipoAsiento.PLATINUM));
            } else {
                Arrays.fill(asientos[i], Asiento.crearAsientoDisponible(TipoAsiento.GOLD));
            }
        }
    }

    public String mostrarSala() {
        StringBuilder sb = new StringBuilder();

        for (Asiento[] asiento : asientos) {
            for (Asiento value : asiento) {
                sb.append("[").append(value.getEstadoAsiento()).append("]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void limpiarSala() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                try {
                    liberarAsiento(i, j);
                } catch (InvalidArgumentE invalidArgumentE) {
                    invalidArgumentE.printStackTrace();
                }
            }
        }
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
}
