package uz.pdp.AvtoTicket.exceptions;

public class UserIsDeletedException extends RuntimeException {
    public UserIsDeletedException(String message) {
        super(message);
    }
}
