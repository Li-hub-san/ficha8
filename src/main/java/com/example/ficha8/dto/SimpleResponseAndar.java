package com.example.ficha8.dto;

import com.example.ficha8.models.Andar;

import java.util.Optional;

public class SimpleResponseAndar extends SimpleResponse{
    private Optional<Andar> andar;

    public Optional<Andar> getAndar() {
        return andar;
    }

    public void setAndar(Optional<Andar> andar) {
        this.andar = andar;
    }
}
