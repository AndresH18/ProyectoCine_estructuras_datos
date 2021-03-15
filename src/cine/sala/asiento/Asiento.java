package cine.sala.asiento;

import java.io.Serializable;

import cine.persona.Cliente;

public class Asiento implements Serializable {

	private Cliente cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "[" + estadoAsiento.toString() + "]";
	}

}
