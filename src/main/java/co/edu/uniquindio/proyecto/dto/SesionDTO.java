package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SesionDTO {

    private String email;
    private String contrasenia;
    private String tipo;
}
