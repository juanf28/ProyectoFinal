package co.edu.uniquindio.proyecto.dto;

import java.util.List;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.Imagen;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProductoDTO {

    @Length(max = 140)
    @NotBlank
    @NotNull
    private String nombre;

    private int codigo;
    @NotBlank
    @NotNull
    private String descripcion;
    @PositiveOrZero
    private int unidades;
    @PositiveOrZero
    private float precio;

    @Positive
    private int codigoVendedor;

    private List<Imagen> imagenes;

    private List<Categoria> categorias;


    private Estado estado;
}
