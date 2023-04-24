package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Embeddable
public class FavoritoId implements Serializable{
    private int codigo_producto;
    private int codigo_usuario;
}