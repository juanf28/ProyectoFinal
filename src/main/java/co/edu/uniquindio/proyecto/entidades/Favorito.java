package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


import java.io.Serializable;

@Entity
@EqualsAndHashCode
public class Favorito implements Serializable {
    @EmbeddedId
    private FavoritoId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_producto", insertable=false, updatable=false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="codigo_usuario", insertable=false, updatable=false)
    private Usuario usuario;

    // constructor, getters y setters
}