package com.Login.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Login.model.Persona;
import com.Login.service.PersonaService;

/**
 * Controlador REST para gestionar las operaciones relacionadas con las personas.
 */
@RestController
@RequestMapping("/Personas/")
public class PersonaRest {
    
    @Autowired
    private PersonaService personaService;
    
    /**
     * Maneja la solicitud GET para obtener todas las personas.
     *
     * @return ResponseEntity con la lista de personas y el estado HTTP correspondiente.
     */
    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersonas() {
        return ResponseEntity.ok(personaService.findAll());
    }
    
    /**
     * Maneja la solicitud POST para guardar una nueva persona.
     *
     * @param persona La persona que se va a guardar.
     * @return ResponseEntity con la persona guardada y el estado HTTP correspondiente.
     */
    /**
     * Maneja la solicitud POST para guardar una nueva persona.
     *
     * @param persona La persona que se va a guardar.
     * @return ResponseEntity con la persona guardada y el estado HTTP correspondiente.
     */
    @PostMapping
    private ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
        try {
            String identificacion = String.valueOf(persona.getIdentificacion());
            
            // Validación de formato de identificación (10 dígitos numéricos)
            if (!identificacion.matches("\\d{10}")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            
            // Validación de identificación con dígitos repetidos
            if (identificacion.matches(".*(\\d)\\1{3,}.*")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            
            // Guardar la persona utilizando el servicio de Persona
            Persona personaGuardada = personaService.save(persona);
            
            // Retornar una respuesta con estado 201 Created y la persona guardada en el cuerpo
            return ResponseEntity.created(new URI("/Personas/" + personaGuardada.getIdPersona())).body(personaGuardada);
        } catch (Exception e) {
            // En caso de excepción, retornar una respuesta con estado 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
