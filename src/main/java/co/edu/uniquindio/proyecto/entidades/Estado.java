package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Estado implements Serializable {

    @Id
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "estado")
    private List<ProductoModerador> moderadores;

    @OneToMany(mappedBy = "estado")
    List<Producto> productos;
}




