package Exception;
public class InvalidSongException extends RuntimeException{
    public String message;
    public InvalidSongException(String mssg)
    {
        this.message=mssg;
    }
    public InvalidSongException()
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
