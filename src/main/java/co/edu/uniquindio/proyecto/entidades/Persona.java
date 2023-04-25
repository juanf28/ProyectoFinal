package co.edu.uniquindio.proyecto.entidades;

import lombok.Builder;

import java.io.Serializable;
public class Persona implements Serializable {
    private String nombreCompleto;
    private  String cedula;

    private String email;
    private String contrasenia;

}
