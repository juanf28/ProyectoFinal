package co.edu.uniquindio.proyecto.dto;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UsuarioGetDTO {

    private int cedula;

    private String nombre;

    private String email;

    private String direccion;

    private String telefono;
}
