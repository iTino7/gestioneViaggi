package sabatinoborrelli.progetto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sabatinoborrelli.progetto.exceptions.BadrequestException;
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
    public EmployeeResponseDTO save(@RequestBody @Validated NewEmployeeDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            String errorMessages = validation.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Errore di validazione");

            throw new BadrequestException(errorMessages);
        }
        return new EmployeeResponseDTO(this.employeeService.save(body).getId());
    }


}
