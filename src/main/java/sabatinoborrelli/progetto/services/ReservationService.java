package sabatinoborrelli.progetto.services;


import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sabatinoborrelli.progetto.entities.Employee;
import sabatinoborrelli.progetto.entities.Journey;
import sabatinoborrelli.progetto.entities.Reservation;
import sabatinoborrelli.progetto.exceptions.NotFoundException;
import sabatinoborrelli.progetto.repositories.ReservationRepository;

import java.time.LocalDate;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JourneyService journeyService;

    public Page<Reservation> getAll(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prenotazione non trovata con questo id: " + id));
    }

    public Reservation create(long employeeId, long journeyId, LocalDate date) throws BadRequestException {
        Employee employee = employeeService.getById(employeeId);
        Journey journey = journeyService.getById(journeyId);

        if (reservationRepository.existsByEmployee_IdAndDate(employeeId, date)) {
            throw new BadRequestException("Dipendente già prenotato per queste date");
        }

        Reservation reservation = new Reservation(journey, employee, date);
        return reservationRepository.save(reservation);
    }

    public void delete(long id) {
        Reservation found = this.getById(id);
        this.reservationRepository.delete(found);
    }


}
