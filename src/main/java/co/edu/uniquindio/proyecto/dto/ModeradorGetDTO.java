package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ModeradorGetDTO {
    private int codigo;
    private String nombre;
    private String password;

    private String correo;
}

