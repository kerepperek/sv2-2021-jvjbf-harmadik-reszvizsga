package vehiclerental;

public class UserNameIsAlreadyTakenException extends RuntimeException {

    public UserNameIsAlreadyTakenException(String errorMessage) {
        super(errorMessage);
    }
}
