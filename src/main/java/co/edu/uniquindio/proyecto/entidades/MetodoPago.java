package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum MetodoPago {
    TARJETA_CREDITO("Tarjeta de crédito"),
    TARJETA_DEBITO("Tarjeta de débito"),
    EFECTIVO("Efectivo");

    private String descripcion;
    private int id;
    MetodoPago(String descripcion) {
        this.descripcion = descripcion;
    }
}
