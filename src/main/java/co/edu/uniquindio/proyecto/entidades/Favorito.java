package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


import java.io.Serializable;

@Entity
@IdClass(FavoritoId.class)
public class Favorito {
    @EmbeddedId
    private FavoritoId id;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name ="codigo_usuario")
    private Usuario usuario;

    // constructor, getters y setters
}
