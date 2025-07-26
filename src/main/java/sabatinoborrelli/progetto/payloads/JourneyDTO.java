package sabatinoborrelli.progetto.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JourneyDTO {
    @NotBlank(message = "La destinazione è obbligatoria")
    String destination;
    @NotNull(message = "La data è obbligatoria")
    String date;
    @NotBlank
    private String state;

    public JourneyDTO(String destination, String date, String state) {
        this.destination = destination;
        this.date = date;
        this.state = state;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "JourneyDTO{" +
                "destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
