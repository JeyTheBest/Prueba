package com.Login.rest;


import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Login.model.Sesiones;
import com.Login.repository.SesionesRepository;

@RestController
public class SesionesRest {

    private final SesionesRepository sesionesRepository;

    public SesionesRest(SesionesRepository sesionesRepository) {
        this.sesionesRepository = sesionesRepository;
    }

    
}
