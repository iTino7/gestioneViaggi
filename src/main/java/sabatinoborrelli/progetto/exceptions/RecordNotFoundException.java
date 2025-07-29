package sabatinoborrelli.progetto.exceptions;

import java.util.UUID;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String record, UUID id) {
        super(record + "with id" + id + " not found");
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

}
