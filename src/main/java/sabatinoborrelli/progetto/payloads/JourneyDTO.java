package sabatinoborrelli.progetto.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JourneyDTO {
    @NotBlank(message = "La destinazione è obbligatoria")
    String destination;
    @NotNull(message = "La data è obbligatoria")
    String date;
}
