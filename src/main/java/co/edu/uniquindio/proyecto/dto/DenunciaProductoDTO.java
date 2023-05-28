package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DenunciaProductoDTO {

    private int codigoProducto;
    private int codigoUsuario;

    private String motivoDenuncia;
}
