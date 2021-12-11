package Response;

public class FollowFriendResponse {
    public String message;

    public FollowFriendResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
