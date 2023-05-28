package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TokenDTO {

    @NotNull
    private String token;

    @NotNull
    private String refreshToken;

}
