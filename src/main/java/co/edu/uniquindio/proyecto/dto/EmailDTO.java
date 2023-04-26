package co.edu.uniquindio.proyecto.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailDTO {

    @NotBlank
    @NotNull
    private String asunto;
    @NotBlank
    @NotNull
    private String cuerpo;
    @NotBlank
    @NotNull
    private String destinatario;
}
