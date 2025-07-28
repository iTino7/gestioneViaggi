package sabatinoborrelli.progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sabatinoborrelli.progetto.entities.Employee;
import sabatinoborrelli.progetto.exceptions.BadrequestException;
import sabatinoborrelli.progetto.exceptions.NotFoundException;
import sabatinoborrelli.progetto.payloads.NewEmployeeDTO;
import sabatinoborrelli.progetto.repositories.EmployeedRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeedRepository employeeRepository;

    @Autowired
    private PasswordEncoder bcrypt;


    public Page<Employee> findAll(int pageNum, int pageSize, String sortBy) {
        if (pageSize > 10) pageSize = 10;
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        return this.employeeRepository.findAll(pageable);
    }

    public Employee save(NewEmployeeDTO payload) {
        // 1. Verifico che l'email non sia già in uso
        this.employeeRepository.findByEmail(payload.getEmail()).ifPresent(user -> {
            throw new BadrequestException("L'email " + user.getEmail() + " è già in uso!");
        });

        // 2. Aggiungo valori server-generated
        Employee newUser = new Employee(payload.getUsername(), payload.getName(), payload.getSurname(), payload.getEmail(), payload.getPassword());


        // 3. Salvo
        Employee savedUser = this.employeeRepository.save(newUser);

        // 4. Log


        // 5. Ritorno l'utente salvato
        return savedUser;
    }

    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(email));
    }

    public Employee getById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dipendente non trovato con id " + id));
    }

    public Employee update(long id, Employee update) {
        Employee found = getById(id);
        found.setUsername(update.getUsername());
        found.setName(update.getName());
        found.setSurname(update.getSurname());
        found.setEmail(update.getEmail());
        return employeeRepository.save(found);
    }

    public void delete(long id) {
        Employee found = this.getById(id);
        this.employeeRepository.delete(found);
    }

}
