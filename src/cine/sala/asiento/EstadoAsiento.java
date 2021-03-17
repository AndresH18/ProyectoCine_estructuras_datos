package cine.sala.asiento;

public enum EstadoAsiento {

    DISPONIBLE("D"),
    RESERVADO("R"),
    OCUPADO("O");
	
	
	private final String caracter;
    EstadoAsiento(String c) {
    	this.caracter = c;
    }
	public String getCaracter() {
		return caracter;
	}
    
    
}
