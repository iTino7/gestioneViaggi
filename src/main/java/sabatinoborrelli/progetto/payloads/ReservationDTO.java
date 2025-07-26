package sabatinoborrelli.progetto.payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ReservationDTO {
    @NotNull(message = "L'id del dipendente è obbligatorio")
    private long employeeId;
    @NotNull(message = "L'id del viaggio è obbligatorio")
    private long journeyId;
    @NotNull(message = "La data della prenotazione è obbligatoria")
    private LocalDate date;
}
