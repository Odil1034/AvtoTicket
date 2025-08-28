package uz.pdp.AvtoTicket.exceptions;

public class WrongPassword extends RuntimeException {

    public WrongPassword(String message) {
        super(message);
    }
}
