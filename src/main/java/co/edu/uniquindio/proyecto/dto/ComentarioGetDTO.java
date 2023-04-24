package co.edu.uniquindio.proyecto.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
public class ComentarioGetDTO {

    private int codigo;

    private LocalDateTime fecha;
    private String mensaje;
    private int codigoUsuario;
    private int codigoProducto;

    public ComentarioGetDTO(Integer codigo, LocalDateTime fechaCreacion, String mensaje, Object codigo1, int codigo2) {
    }
}
