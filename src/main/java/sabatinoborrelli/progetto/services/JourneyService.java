package sabatinoborrelli.progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sabatinoborrelli.progetto.entities.Journey;
import sabatinoborrelli.progetto.exceptions.NotFoundException;
import sabatinoborrelli.progetto.repositories.JourneyRepository;

import java.util.UUID;

@Service
public class JourneyService {
    @Autowired
    private JourneyRepository journeyRepository;

    public Page<Journey> getAll(Pageable pageable) {
        return journeyRepository.findAll(pageable);
    }

    public Journey getById(UUID id) {
        return journeyRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Viaggio con id non trovato: " + id));
    }

    public Journey create(Journey journey) {
        return journeyRepository.save(journey);
    }

    public Journey update(UUID id, Journey update) {
        Journey found = getById(id);
        found.setDestination(update.getDestination());
        found.setDate(update.getDate());
        found.setState(update.getState());
        return journeyRepository.save(found);
    }

    public void delete(UUID id) {
        Journey found = this.getById(id);
        this.journeyRepository.delete(found);
    }
}
