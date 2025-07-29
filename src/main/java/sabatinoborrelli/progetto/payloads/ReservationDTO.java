package sabatinoborrelli.progetto.payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class ReservationDTO {
    @NotNull(message = "L'id del dipendente è obbligatorio")
    private UUID employeeId;
    @NotNull(message = "L'id del viaggio è obbligatorio")
    private UUID journeyId;
    @NotNull(message = "La data della prenotazione è obbligatoria")
    private LocalDate date;

    public ReservationDTO(UUID employeeId, UUID journeyId, LocalDate date) {
        this.employeeId = employeeId;
        this.journeyId = journeyId;
        this.date = date;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public UUID getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(UUID journeyId) {
        this.journeyId = journeyId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "employeeId=" + employeeId +
                ", journeyId=" + journeyId +
                ", date=" + date +
                '}';
    }
}
