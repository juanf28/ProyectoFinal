package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {

    private int codigo;

    private LocalDateTime fechaLimite;

    private Estado estado;

    private LocalDateTime fechaCreacion;

    private String nombre;

    private String descripcion;

    private float precio;

    private int unidades;

    private int cedulaUsuario;

    private  List<String> imagenes;;

    private List<Categoria> categorias;

}