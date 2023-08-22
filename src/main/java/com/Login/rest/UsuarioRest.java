package com.Login.rest;

import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Login.model.Persona;
import com.Login.model.Usuario;

/**
 * Controlador REST para gestionar las operaciones relacionadas con los usuarios.
 */
@RestController
@RequestMapping("/Usuarios/")
public class UsuarioRest {
    
    /**
     * Maneja la solicitud POST para guardar un nuevo usuario.
     *
     * @param usuario El usuario que se va a guardar.
     * @return ResponseEntity con el usuario guardado y el estado HTTP correspondiente.
     */
    /**
     * Maneja la solicitud POST para guardar un nuevo usuario.
     *
     * @param usuario El usuario que se va a guardar.
     * @return ResponseEntity con el usuario guardado y el estado HTTP correspondiente.
     */
    @PostMapping
    private ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        try {
            Persona persona = usuario.getPersona();
            
            // Generar parte del correo basado en el nombre y apellidos
         // Obtener el primer nombre de la persona
            String primerNombre = persona.getNombres().split(" ")[0]; 

            // Dividir los apellidos en partes usando un espacio como separador
            String[] partesApellidos = persona.getApellidos().split(" ");

            // Obtener el primer apellido de la persona
            String primerApellido = partesApellidos[0];

            // Obtener el segundo apellido de la persona, si existe; de lo contrario, asignar cadena vacía
            String segundoApellido = partesApellidos.length > 1 ? partesApellidos[1] : "";

            // Crear una base para el correo generando usando la primera letra del primer nombre,
            // el primer apellido y la primera letra del segundo apellido (si existe)
            String baseCorreoGenerado = primerNombre.toLowerCase().charAt(0) + primerApellido.toLowerCase() + segundoApellido.toLowerCase().charAt(0);

            // Combinar la base del correo generada con el dominio "@mail.com"
            String correoGenerado = baseCorreoGenerado + "@" + "mail.com";

            // Verificar si el correo generado ya existe en la base de datos
            boolean correoExistente = verificarCorreoExistente(correoGenerado); 

            // Si el correo generado ya existe, generar uno nuevo con un número
            if (correoExistente) {
                int numero = 1;
                while (correoExistente) {
                    String nuevoCorreo = baseCorreoGenerado + numero + "@" + "mail.com";
                    correoExistente = verificarCorreoExistente(nuevoCorreo);
                    if (!correoExistente) {
                        usuario.setCorreo(nuevoCorreo);
                        break;
                    }
                    numero++;
                }
            } else {
                // Si el correo generado no existe, usarlo tal cual
                usuario.setCorreo(correoGenerado);
            }

            // Validar el formato del nombre de usuario
            String nombreUsuario = usuario.getUsuario();
            if (!nombreUsuario.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            // Validar el formato de la contraseña
            String contraseña = usuario.getContrasena();
            if (!contraseña.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\d\\s])[^\\s]{8,}$")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            // Guardar el usuario utilizando la lógica correspondiente

            // Retornar una respuesta con estado 201 Created y el usuario guardado en el cuerpo
            return ResponseEntity.created(URI.create("/Usuarios/" + usuario.getIdUsuario())).body(usuario);

        } catch (Exception e) {
            // En caso de excepción, retornar una respuesta con estado 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    
    /**
     * Verifica si un correo generado ya existe.
     *
     * @param correoGenerado El correo generado a verificar.
     * @return `true` si el correo ya existe, `false` si no existe.
     */
    private boolean verificarCorreoExistente(String correoGenerado) {
        // Lógica para verificar la existencia del correo en la base de datos
        // (La implementación real debe ir aquí)
        return false;
    }
}
