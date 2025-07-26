package sabatinoborrelli.progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabatinoborrelli.progetto.entities.Journey;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {
}
