package sabatinoborrelli.progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabatinoborrelli.progetto.entities.Employee;

@Repository
public interface EmployeedRepository extends JpaRepository<Employee, Long> {
}
