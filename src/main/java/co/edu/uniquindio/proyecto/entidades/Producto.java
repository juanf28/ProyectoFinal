package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @ElementCollection
    @Column(nullable = false)
    private List<String> imagen;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    @Column(nullable = false)
    private int unidades;

    @ManyToOne
    @JoinColumn
    private Usuario vendedor;

    @ManyToMany
    @Column(nullable = false)
    public List<Categoria> categoria;

}
