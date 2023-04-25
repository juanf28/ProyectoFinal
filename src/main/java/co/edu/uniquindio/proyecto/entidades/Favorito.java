package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


import java.io.Serializable;

@Entity
public class Favorito {
    @EmbeddedId
    private FavoritoId id;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", insertable=false, updatable=false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name ="codigo_usuario", insertable=false, updatable=false)
    private Usuario usuario;

    // constructor, getters y setters
}