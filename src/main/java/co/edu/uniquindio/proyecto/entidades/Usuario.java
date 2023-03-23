package co.edu.uniquindio.proyecto.entidades;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    @Column(length = 100, nullable = false)
    private String nombreCompleto;
    private String numTelefono;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String contrasenia;
    private String estado;
    private String direccion;

}
