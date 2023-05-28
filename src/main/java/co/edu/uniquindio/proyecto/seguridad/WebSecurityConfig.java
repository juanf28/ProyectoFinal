package co.edu.uniquindio.proyecto.seguridad;

import co.edu.uniquindio.proyecto.seguridad.config.JwtAuthenticationEntryPoint;
import co.edu.uniquindio.proyecto.seguridad.config.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtEntryPoint;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();

        //http.authorizeHttpRequests().requestMatchers("/api/auth/login/**").permitAll();
        //http.authorizeHttpRequests().requestMatchers("/api/usuarios/crear/**",
              //  "/api/usuarios/eliminar/**",
            //    "/api/usuarios/actualizar/**",
          //      "/api/usuarios/obtener/**").permitAll();
       // http.authorizeHttpRequests().requestMatchers("/api/productos/crear/**",
         //       "/api/productos/eliminar/**",
           //     "/api/productos/actualizar/**",
             //   "/api/productos/obtener/**").permitAll();
        http.authorizeHttpRequests().anyRequest().permitAll();

        /*
        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        */


        return http.build();
    }


}
