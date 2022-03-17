package com.example.ficha8.dto;

import com.example.ficha8.models.Andar;

import java.util.List;

public class SimpleResponseAndares extends SimpleResponse {
    private List<Andar> andares;

    public List<Andar> getAndares() {
        return andares;
    }

    public void setAndares(List<Andar> andares) {
        this.andares = andares;
    }
}
