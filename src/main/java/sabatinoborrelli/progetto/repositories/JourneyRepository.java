package sabatinoborrelli.progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabatinoborrelli.progetto.entities.Journey;

import java.util.UUID;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, UUID> {
}
