package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@ToString

public class Moderador extends Usuario {

    @Id
    @Column(length = 15, nullable = false)
    private int codigo;

    @Column
    String correo;

    @OneToMany(mappedBy="producto")
    List<Producto> productos;


}
