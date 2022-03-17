package com.example.ficha8.services;

import com.example.ficha8.models.Andar;
import com.example.ficha8.models.CentroComercial;
import com.example.ficha8.repository.AndarRepository;
import com.example.ficha8.repository.CentroComercialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AndarService {
    private final AndarRepository andarRepository;
    private final CentroComercialRepository centroComercialRepository;

    public AndarService(AndarRepository andarRepository, CentroComercialRepository centroComercialRepository) {
        this.andarRepository = andarRepository;
        this.centroComercialRepository = centroComercialRepository;
    }

    public Optional<Andar> addAndar(Andar andar) {
        // TODO: verificação se andar existe
        if (andar.getId() != null) {
            return Optional.empty();
        }

        return Optional.of(andarRepository.save(andar));
    }

    public List<Andar> getAllAndar() {
        return (List<Andar>) andarRepository.findAll();
    }

    public boolean deleteAndar(Long id) {
        if (andarRepository.findById(id).isEmpty()) {
            return false;
        }

        andarRepository.deleteById(id);
        return true;
    }

    public Optional<Andar> addAndarToCentro(Long andarId, Long centroComercialId) {
        Optional<Andar> andarOptional = andarRepository.findById(andarId);
        Optional<CentroComercial> centroComercialOptional = centroComercialRepository.findById(centroComercialId);

        if (andarOptional.isPresent() && centroComercialOptional.isPresent()) {
            andarRepository.save(andarOptional.get());
            return andarOptional;
        }

        return Optional.empty();
    }
}