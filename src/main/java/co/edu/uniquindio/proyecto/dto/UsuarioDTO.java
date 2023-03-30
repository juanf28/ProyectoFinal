package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {
     int codigo;

    @NotNull
    @NotBlank

    String nombre;

    @NotNull
    @NotBlank
    @Email
    @Length(max=150)
    String email;
    String contrasenia;


    String direccion;

    @NotNull
    @NotBlank
    @Length(max=12)
    String telefono;
}
