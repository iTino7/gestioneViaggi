package sabatinoborrelli.gestioneViaggi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabatinoborrelli.gestioneViaggi.entities.Journey;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {
}
