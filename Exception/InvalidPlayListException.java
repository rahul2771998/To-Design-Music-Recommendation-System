package Exception;

public class InvalidPlayListException extends RuntimeException{
    public String message;
    public InvalidPlayListException(String mssg)
    {
        this.message=mssg;
    }
    public InvalidPlayListException()
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
