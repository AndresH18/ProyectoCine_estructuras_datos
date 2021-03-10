package exceptions;

public class InvalidRowArgumentE extends InvalidArgumentE {

	public InvalidRowArgumentE(int n) {
		super("LA FILA [" + n + "] NO ES VALIDA");
	}

}
