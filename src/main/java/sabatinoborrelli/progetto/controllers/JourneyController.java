package sabatinoborrelli.progetto.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sabatinoborrelli.progetto.entities.Journey;
import sabatinoborrelli.progetto.enums.StateJourney;
import sabatinoborrelli.progetto.payloads.JourneyDTO;
import sabatinoborrelli.progetto.services.JourneyService;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/journeys")
public class JourneyController {
    @Autowired
    private JourneyService journeyService;

    @GetMapping
    public Page<Journey> getAll(Pageable pageable) {
        return journeyService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Journey getById(@PathVariable UUID id) {
        return journeyService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Journey create(@Valid @RequestBody JourneyDTO dto) {
        Journey journey = new Journey(dto.getDestination(), StateJourney.valueOf(dto.getState()), LocalDate.parse(dto.getDate()));
        return journeyService.create(journey);
    }

    @PutMapping("/{id}")
    public Journey update(@PathVariable UUID id, @Valid @RequestBody JourneyDTO dto) {
        Journey journey = new Journey(dto.getDestination(), StateJourney.valueOf(dto.getState()), LocalDate.parse(dto.getDate()));
        return journeyService.update(id, journey);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        journeyService.delete(id);
    }
}
