package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity

public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "producto")
    List<Imagen> imagenes;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private float precio;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    ProductoModerador productoModerador;

    @ManyToOne
    private Usuario vendedor;

    @Column(nullable = false)
    private int unidades;

    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> productoModeradores;


    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    List<Favorito> favoritos;

    @OneToMany(mappedBy = "compra")
    List<DetalleCompra> detalleCompraList;

    @ManyToMany(mappedBy = "productos")
    List<Categoria> categorias;

    @ManyToOne
    private Estado estado;



}
