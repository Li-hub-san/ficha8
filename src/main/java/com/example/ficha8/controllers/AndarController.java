package com.example.ficha8.controllers;

import com.example.ficha8.dto.SimpleResponse;
import com.example.ficha8.dto.SimpleResponseAndar;
import com.example.ficha8.models.Andar;
import com.example.ficha8.services.AndarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class AndarController {
    private final AndarService andarService;

    @Autowired
    public AndarController(AndarService andarService) {
        this.andarService = andarService;
    }

    @GetMapping("/addAndar")
    public ResponseEntity<SimpleResponse> addAndar(@RequestBody Andar andar){
        SimpleResponseAndar sra= new SimpleResponseAndar();

        Optional<Andar> andarOptional = andarService.addAndar(andar);
        if (andarOptional.isPresent()){
            sra.setStatus(true);
            sra.setMessage("Andar adicionado com sucesso");
            sra.setAndar(andarOptional.get());

            return ResponseEntity.status(HttpStatus.OK).body(sra);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sra);
    }

}
