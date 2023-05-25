package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ContraseñaDTO {

    @NotNull(message = "La contraseña no puede ser nulo")
    @NotBlank(message = "La contraseña no puede ser vacio")
    private String password;

    @NotNull(message = "La contraseña no puede ser nulo")
    @NotBlank(message = "La contraseña no puede ser vacio")
    private String passwordRepeated;


}
