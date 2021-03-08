package cine.sala.asiento;

public class Asiento {

	EstadoAsiento estado;
	TipoAsiento tipoAsiento;
	
	public void setEstado(EstadoAsiento estado) {
		this.estado=estado;
	}
	public void getEstado() {
		return estado;
	}
	public void getTipoAsiento() {
		return tipoAsiento;
	}
}
