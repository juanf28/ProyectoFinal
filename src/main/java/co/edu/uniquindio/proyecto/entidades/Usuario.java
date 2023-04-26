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
@EqualsAndHashCode
@ToString
public class Usuario extends Persona implements Serializable {

    @Column(length = 20, nullable = false)
    private String numTelefono;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @Column(length = 100, nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "usuario")
    List<Favorito> favoritos;


}
