package co.edu.uniquindio.proyecto.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ComentarioDTO {

    private String mensaje;
    private int codigoUsuario;
    private int codigoProducto;

}
