package ${package}.exception;

/**
 * The purpose of this class is to define not implemented exception.
 * 
 * @author Praveen Malla
 *
 */
public class NotImplementedException extends RuntimeException {

	private static final long serialVersionUID = 3557546843525567475L;

	public NotImplementedException(String message) {
		super(message);
	}

}