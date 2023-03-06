package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Libro implements Serializable {
    @Id
    @Column(length=10,nullable=false)
    private String isbn;
    @Column(length = 100, nullable=false)
    private String nombre;
    private int unidades;
    @Column(nullable = false)
    private int anio;

}
