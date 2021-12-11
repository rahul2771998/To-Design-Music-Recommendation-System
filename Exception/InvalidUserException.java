package Exception;

public class InvalidUserException extends RuntimeException{
    public String message;
    public InvalidUserException(String mssg)
    {
        this.message=mssg;
    }
    public InvalidUserException()
    {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
