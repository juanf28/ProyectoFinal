package co.edu.uniquindio.proyecto.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {
    String codigo;
    String nombre;
    String email;
    String contrasenia;
    String direccion;
    String telefono;
}
