package com.example.ficha8.dto;

import com.example.ficha8.models.CentroComercial;

import java.util.List;

public class SimpleResponseCentrosComerciais extends SimpleResponse {
    private List<CentroComercial> centrosComerciais;

    public List<CentroComercial> getCentrosComerciais() {
        return centrosComerciais;
    }

    public void setCentrosComerciais(List<CentroComercial> centrosComerciais) {
        this.centrosComerciais = centrosComerciais;
    }
}
