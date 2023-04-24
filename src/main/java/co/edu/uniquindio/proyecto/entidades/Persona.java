package co.edu.uniquindio.proyecto.entidades;

import lombok.Builder;

import java.io.Serializable;
// cifuentes y mosquera niches
public class Persona implements Serializable {
    private String nombreCompleto;
    private  String cedula;
    private String contrasenia;

    /*
    public Persona(String nombreCompleto, String cedula, String contrasenia) {
        this.nombreCompleto=nombreCompleto;
        this.cedula=cedula;
        this.contrasenia=contrasenia;
    }

     */
}
