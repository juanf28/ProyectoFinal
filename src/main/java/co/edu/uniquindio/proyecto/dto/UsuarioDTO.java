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
    @Length(max=160, message = "El nombre es demasiado largo ")

    private String nombre;

    @NotNull
    @NotBlank
    @Email
    @Length(max=150, message = "Correo demasiado extenso ")
   private String email;


    @NotNull
    @NotBlank
    @Email
    @Length(max=150, message = "Contraseña demasiado extensa, excede los 150 caracteres ")
    private String contrasenia;

    @NotNull
    @NotBlank
    @Email
    @Length(max=100, message = "Direccion demasiado larga ")
    private String direccion;

    @NotNull
    @NotBlank
    @Length(max=12)
    private String telefono;
}
