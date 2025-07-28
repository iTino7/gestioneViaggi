package sabatinoborrelli.progetto.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {
    private List<String> errorMessages;

    public ValidationException(List<String> errorMessages) {
        super("Errori vari di validazione!");
        this.errorMessages = errorMessages;
    }
}
