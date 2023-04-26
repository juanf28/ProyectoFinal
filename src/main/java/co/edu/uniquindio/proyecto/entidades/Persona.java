package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private int cedula;

    @Column(length = 100, nullable = false)
    private String nombreCompleto;


    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String contrasenia;

}
