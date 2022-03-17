package com.example.ficha8.controllers;

import com.example.ficha8.dto.SimpleResponse;
import com.example.ficha8.dto.SimpleResponseAndar;
import com.example.ficha8.dto.SimpleResponseAndares;
import com.example.ficha8.models.Andar;
import com.example.ficha8.services.AndarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AndarController {
    private final AndarService andarService;

    @Autowired
    public AndarController(AndarService andarService) {
        this.andarService = andarService;
    }

    @PostMapping("/addAndar")
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

    @GetMapping("/getAllAndar")
    public ResponseEntity<SimpleResponse> getAllAndar(){
        SimpleResponseAndares sra = new SimpleResponseAndares();

        List<Andar> andares = andarService.getAllAndar();
        sra.setStatus(true);
        sra.setMessage("Andares encontrados");
        sra.setAndares(andares);

        return ResponseEntity.status(HttpStatus.OK).body(sra);
    }

    @DeleteMapping("/deleteAndar/{id}")
    public ResponseEntity<SimpleResponse> deleteAndar(@PathVariable Long id){
        SimpleResponseAndar sra = new SimpleResponseAndar();
        boolean apagou = andarService.deleteAndar(id);

        if (apagou){
            sra.setStatus(true);
            sra.setMessage("Andar eliminado com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(sra);
        }

        sra.setMessage("Andar com id " + id + " não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sra);
    }

    @PostMapping("/addAndar/{andar_id}/centroComercial/{centro_comercial_id}")
    public ResponseEntity<SimpleResponse> addAndarToCentro(@RequestBody Andar andar, @PathVariable Long centro_comercial_id){
        SimpleResponseAndar sra = new SimpleResponseAndar();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sra);
    }

}
