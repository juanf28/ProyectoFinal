package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductoModerador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Length(max = 50)
    @NotNull
    @Column(length = 50, nullable = false)
    private String motivo;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "codigo_moderador")
    Moderador moderador;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;


    @ManyToOne
    @JoinColumn(name="codigo_estado")
    private Estado estado;




}
