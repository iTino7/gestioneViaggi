package sabatinoborrelli.progetto.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "La passord è obbligatoria")
    @Size(min = 4)
    String password;

    public NewEmployeeDTO(String username, String name, String surname, String email, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NewEmployeeDTO{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
