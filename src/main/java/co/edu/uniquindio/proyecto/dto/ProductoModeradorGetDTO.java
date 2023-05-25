package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class ProductoModeradorGetDTO {



    private int codigo;

    private String motivo;

    private LocalDateTime fecha;

    Moderador moderador;

    private Producto producto;

    private Estado estado;
}
