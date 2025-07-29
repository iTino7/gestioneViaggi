package sabatinoborrelli.progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabatinoborrelli.progetto.entities.Employee;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeedRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByEmail(String email);

    boolean existsByEmail(String email);
}
