package sabatinoborrelli.progetto.controllers;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sabatinoborrelli.progetto.payloads.EmployeeResponseDTO;
import sabatinoborrelli.progetto.payloads.LoginDTO;
import sabatinoborrelli.progetto.payloads.LoginRespDTO;
import sabatinoborrelli.progetto.payloads.NewEmployeeDTO;
import sabatinoborrelli.progetto.services.AuthService;
import sabatinoborrelli.progetto.services.EmployeeService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody LoginDTO body) {
        String accessToken = authService.authenticEmployee(body);
        return new LoginRespDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponseDTO save(@RequestBody @Validated NewEmployeeDTO body, BindingResult validation) throws BadRequestException {
        if (validation.hasErrors()) {
            throw new BadRequestException((Throwable) validation.getAllErrors());
        }
        return new EmployeeResponseDTO(this.employeeService.save(body).getId());
    }


}
