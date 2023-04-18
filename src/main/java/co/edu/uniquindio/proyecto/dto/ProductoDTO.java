package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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
    private Estado estado;
    @Positive
    private int codigoVendedor;

    private List<String> imagenes;
    public List<Categoria> categorias;
}
