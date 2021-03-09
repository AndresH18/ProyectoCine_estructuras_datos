package exceptions;

public class InvalidColumnArgumentE extends InvalidArgumentE {

	public InvalidColumnArgumentE(int n) {
		super("LA COLUMNA[" + n + "] NO ES VALIDA");
	}
}
