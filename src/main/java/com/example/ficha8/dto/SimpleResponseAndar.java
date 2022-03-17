package com.example.ficha8.dto;

import com.example.ficha8.models.Andar;

public class SimpleResponseAndar extends SimpleResponse{
    private Andar andar;

    public Andar getAndar() {
        return andar;
    }

    public void setAndar(Andar andar) {
        this.andar = andar;
    }
}
