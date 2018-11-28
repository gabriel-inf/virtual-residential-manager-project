package systemexceptions;

public class IdentificationParametersException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public IdentificationParametersException() {
		super("Invalid parameters used to identify person");
	}
}
