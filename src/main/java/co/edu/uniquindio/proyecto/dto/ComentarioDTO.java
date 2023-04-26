package co.edu.uniquindio.proyecto.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@ToString
public class ComentarioDTO {
    @NotNull
    @Length(max=100, message = "El comentario excede su cantidad de caracteres (100)")

    private String mensaje;
    private int codigoUsuario;
    private int codigoProducto;

}
