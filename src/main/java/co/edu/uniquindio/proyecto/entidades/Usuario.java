package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private int cedula;

    @Column(length = 100, nullable = false)
    private String nombreCompleto;

    @Column(length = 20, nullable = false)
    private String numTelefono;


    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String contrasenia;

    @OneToMany(mappedBy = "comentario")
    private List<Comentario> comentarios;

    @Column(length = 100, nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "favorito")
    List<Favorito> favoritos;


}
