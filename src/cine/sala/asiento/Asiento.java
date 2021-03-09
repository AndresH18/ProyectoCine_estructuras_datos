package cine.sala.asiento;

public class Asiento {

	private EstadoAsiento estadoAsiento;
	private TipoAsiento tipoAsiento;
	
	public Asiento(EstadoAsiento estado, TipoAsiento tipo) {
		this.estadoAsiento = estado;
		this.tipoAsiento = tipo;
	}
	
	public static Asiento crearAsientoDisponible(TipoAsiento tipo) {
		return new Asiento(EstadoAsiento.DISPONIBLE, tipo);
	}

	public void setEstadoAsiento(EstadoAsiento estado) {
		this.estadoAsiento = estado;
	}

	public EstadoAsiento getEstadoAsiento() {
		return estadoAsiento;
	}

	public TipoAsiento getTipoAsiento() {
		return tipoAsiento;
	}
}
