package Response;

public class AddFriendResponse {
    public String message;

    public  AddFriendResponse (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
