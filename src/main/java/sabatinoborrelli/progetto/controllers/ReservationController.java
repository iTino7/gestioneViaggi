package sabatinoborrelli.progetto.controllers;


import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sabatinoborrelli.progetto.entities.Reservation;
import sabatinoborrelli.progetto.payloads.ReservationDTO;
import sabatinoborrelli.progetto.services.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public Page<Reservation> getAll(Pageable pageable) {
        return reservationService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable long id) {
        return reservationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@Valid @RequestBody ReservationDTO dto) throws BadRequestException {
        return reservationService.create(dto.getEmployeeId(), dto.getJourneyId(), dto.getDate());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        reservationService.delete(id);
    }
}
