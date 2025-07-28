package sabatinoborrelli.progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sabatinoborrelli.progetto.entities.Employee;
import sabatinoborrelli.progetto.exceptions.UnauthorizedException;
import sabatinoborrelli.progetto.payloads.LoginDTO;
import sabatinoborrelli.progetto.security.JwTools;

@Service
public class AuthService {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwTools jwTools;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticEmployee(LoginDTO body) {
        Employee employee = this.employeeService.findByEmail(body.email());
        if (passwordEncoder.matches(body.password(), employee.getPassword())) {
            return jwTools.createToken(employee);
        } else {
            throw new UnauthorizedException("Invalid email or password");
        }
    }


}
