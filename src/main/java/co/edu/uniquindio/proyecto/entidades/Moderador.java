package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Moderador extends Usuario {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 15, nullable = false)
    private int codigo;

    @Column
    String correo;

    @OneToMany(mappedBy="producto")
    List<Producto> productos;


}
