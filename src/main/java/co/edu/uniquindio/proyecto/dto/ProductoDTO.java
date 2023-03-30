package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private int unidades;
    private float precio;
    private int codigoVendedor;
    private List<String> imagenes;
    public List<Categoria> categorias;
}
