package sabatinoborrelli.progetto.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewEmployeeDTO {
    @NotBlank
    @Size(min = 1, max = 25, message = "la lunghezza dell'username deve essere compresa tra 1 e 25")
    String username;
    @NotBlank
    @Size(min = 4, max = 10, message = "la lunghezza del nome deve essere compresa tra 4 e 15")
    String name;
    @NotBlank
    @Size(min = 1, max = 15, message = "la lunghezza del cognome deve essere compresa tra 1 e 15")
    String surname;
    @NotBlank
    @Email(message = "formato email non valito")
    String email;

}
