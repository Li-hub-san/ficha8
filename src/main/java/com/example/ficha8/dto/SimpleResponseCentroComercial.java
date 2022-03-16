package com.example.ficha8.dto;

import com.example.ficha8.models.CentroComercial;

public class SimpleResponseCentroComercial extends SimpleResponse{
    private CentroComercial centroComercial;

    public CentroComercial getCentroComercial() {
        return centroComercial;
    }

    public void setCentroComercial(CentroComercial centroComercial) {
        this.centroComercial = centroComercial;
    }
}
