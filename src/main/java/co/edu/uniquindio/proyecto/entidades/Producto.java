package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 100, nullable = false)
    private String nombre;


    @ElementCollection
    @NotNull
    List<String> imagenes;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private float precio;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @ManyToOne
    @JoinColumn(name = "codigo_moderador")
    ProductoModerador productoModerador;

    @ManyToOne
    private Usuario vendedor;

    @Column(nullable = false)
    private int unidades;


    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    List<Favorito> favoritos;

    @OneToMany(mappedBy = "producto")
    List<DetalleCompra> detalleCompraList;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    List<Categoria> categorias;

    private Estado estado;



}
