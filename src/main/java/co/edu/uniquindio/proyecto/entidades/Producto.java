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
    private int codigoVendedor;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @ManyToOne
    @JoinColumn(name = "codigo_vendedor")
    ProductoModerador productoModerador;

    @ManyToOne
    Moderador moderador;

    @Column(nullable = false)
    private int unidades;

    @OneToMany(mappedBy = "codigo_producto")
    private List<ProductoModerador> moderadores;


    @OneToMany(mappedBy = "codigo_producto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "codigo_producto")
    List<Favorito> favoritos;

    @OneToMany(mappedBy = "codigo_compra")
    List<DetalleCompra> detalleCompraList;

    @ManyToMany(mappedBy = "productos")
    List<Categoria> categorias;

    @ManyToOne
    private Estado estado;

}
