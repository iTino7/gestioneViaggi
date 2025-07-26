package sabatinoborrelli.progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabatinoborrelli.progetto.entities.Reservation;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByEmployee_IdAndDate(Long employeeId, LocalDate date);
}
