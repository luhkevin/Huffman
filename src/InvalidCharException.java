/**
 * -------------------
 * @author CIS-121 Staff
 * @version 1.0 - 03/19/08
 */

@SuppressWarnings("serial")
public class InvalidCharException extends IllegalArgumentException
{

	public InvalidCharException()
	{
		super();
	}

	public InvalidCharException(String message)
	{
		super(message);
	}

	public InvalidCharException(Throwable cause)
	{
		super(cause);
	}

	public InvalidCharException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
