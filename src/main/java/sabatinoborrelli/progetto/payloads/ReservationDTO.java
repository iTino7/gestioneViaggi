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

    public ReservationDTO(long employeeId, long journeyId, LocalDate date) {
        this.employeeId = employeeId;
        this.journeyId = journeyId;
        this.date = date;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(long journeyId) {
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
