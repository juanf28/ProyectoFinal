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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(length = 100, nullable = false)
    private String nombre;
    private List<String> imagen;

    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private float precio;

    @ManyToMany
    private int codigoVendedor;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @Column(nullable = false)
    private Estado estado;

    @Column(nullable = false)
    private int unidades;

    @Column(nullable = false)
    private Usuario vendedor;
    @Column(nullable = false)
    public List<Categoria> categoria;








}
