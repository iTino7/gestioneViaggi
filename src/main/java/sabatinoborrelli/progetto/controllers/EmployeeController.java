package sabatinoborrelli.progetto.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sabatinoborrelli.progetto.entities.Employee;
import sabatinoborrelli.progetto.payloads.NewEmployeeDTO;
import sabatinoborrelli.progetto.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getAll(Pageable pageable) {
        return employeeService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@Valid @RequestBody NewEmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setUsername(dto.getUsername());
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setEmail(dto.getEmail());
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable long id, @Valid @RequestBody NewEmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setUsername(dto.getUsername());
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setEmail(dto.getEmail());
        return employeeService.create(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        employeeService.delete(id);
    }


}
