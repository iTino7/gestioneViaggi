package sabatinoborrelli.progetto.payloads;

import java.time.LocalDateTime;

public record ErrorDTO(String message, LocalDateTime time) {
}
