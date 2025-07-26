package sabatinoborrelli.progetto.entities;


import jakarta.persistence.*;
import sabatinoborrelli.progetto.enums.StateJourney;

import java.time.LocalDate;

@Entity
@Table(name = "journeys")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String destination;
    @Column
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column
    private StateJourney state;

    public Journey(String destination, StateJourney state, LocalDate date) {
        this.destination = destination;
        this.state = state;
        this.date = date;
    }

    public long getId() {
        return id;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StateJourney getState() {
        return state;
    }

    public void setState(StateJourney state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", data=" + date +
                ", state=" + state +
                '}';
    }
}
