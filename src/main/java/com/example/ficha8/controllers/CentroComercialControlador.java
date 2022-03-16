package com.example.ficha8.controllers;

import com.example.ficha8.dto.SimpleResponse;
import com.example.ficha8.dto.SimpleResponseCentroComercial;
import com.example.ficha8.dto.SimpleResponseCentrosComerciais;
import com.example.ficha8.models.CentroComercial;
import com.example.ficha8.services.CentroComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CentroComercialControlador {
    private final CentroComercialService centroComercialService;

    @Autowired
    public CentroComercialControlador(CentroComercialService centroComercialService) {
        this.centroComercialService = centroComercialService;
    }

    @PostMapping("/addCentroComercial")
    public ResponseEntity<SimpleResponse> addCentroComercial(@RequestBody CentroComercial centroComercial) {
        SimpleResponseCentroComercial srCC = new SimpleResponseCentroComercial();

        Optional<CentroComercial> centroOptional = centroComercialService.addCentroComercial(centroComercial);
        if (centroOptional.isPresent()) {
            srCC.setStatus(true);
            srCC.setMessage("Centro Comercial adicionado com sucesso");
            srCC.setCentroComercial(centroOptional.get());

            return ResponseEntity.status(HttpStatus.OK).body(srCC);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srCC);
    }

    @DeleteMapping("/deleteCentroComercial/{id}")
    public ResponseEntity<SimpleResponse> deleteCentroComercial(@PathVariable Long id) {
        SimpleResponse sr = new SimpleResponse();

        boolean apagou = centroComercialService.deleteCentroComercial(id);
        if (apagou) {
            sr.setStatus(true);
            sr.setMessage("Centro Comercial apagado com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(sr);
        }

        sr.setMessage("Centro comercial com id " + id + " não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sr);
    }

    @GetMapping("/getAllCentroComercial")
    public ResponseEntity<SimpleResponse> getAllCentroComercial() {
        SimpleResponseCentrosComerciais srCC = new SimpleResponseCentrosComerciais();

        List<CentroComercial> allCentroComercial = centroComercialService.getAllCentroComercial();
        srCC.setStatus(true);
        srCC.setMessage("Centros Comerciais encontrados");
        srCC.setCentrosComerciais(allCentroComercial);

        return ResponseEntity.status(HttpStatus.OK).body(srCC);
    }

    @GetMapping("/getCentroComercialById/{id}")
    public ResponseEntity<SimpleResponse> getCentroComercialById(@PathVariable Long id) {
        SimpleResponseCentroComercial srCC = new SimpleResponseCentroComercial();

        Optional<CentroComercial> centroComercialOptional = centroComercialService.getCentroComercialById(id);
        if (centroComercialOptional.isPresent()) {
            srCC.setStatus(true);
            srCC.setMessage("Centro Comercial encontrado");
            srCC.setCentroComercial(centroComercialOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(srCC);
        }

        srCC.setMessage("Centro comercial com id " + id + " não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(srCC);
    }

}
