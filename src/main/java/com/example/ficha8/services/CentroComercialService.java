package com.example.ficha8.services;

import com.example.ficha8.models.CentroComercial;
import com.example.ficha8.repository.CentroComercialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentroComercialService {
    private final CentroComercialRepository centroComercialRepository;

    public CentroComercialService(CentroComercialRepository centroComercialRepository) {
        this.centroComercialRepository = centroComercialRepository;
    }

    public Optional<CentroComercial> addCentroComercial(CentroComercial centroComercial) {
        // TODO: validações dos campos
        if (centroComercial.getId() != null) {
            return Optional.empty();
        }

        return Optional.of(centroComercialRepository.save(centroComercial));
    }

    public boolean deleteCentroComercial(Long id) {
        if (centroComercialRepository.findById(id).isEmpty()) {
            return false;
        }

        centroComercialRepository.deleteById(id);
        return true;
    }

    public Optional<CentroComercial> getCentroComercialById(Long id) {
        return centroComercialRepository.findById(id);
    }

    public List<CentroComercial> getAllCentroComercial() {
        return (List<CentroComercial>) centroComercialRepository.findAll();
    }
}
