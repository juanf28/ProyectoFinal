package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String comentario;
    private String idUsuario;
    private String idProducto;
}
