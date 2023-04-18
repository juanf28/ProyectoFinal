package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UsuarioDTO {
    private int cedula;

    @NotNull
    @NotBlank

    private String nombre;

    @NotNull
    @NotBlank
    @Email
    @Length(max=150)
   private String email;
    private String contrasenia;


    private String direccion;

    @NotNull
    @NotBlank
    @Length(max=12)
    private String telefono;
}
