package com.example.ficha8.services;

import com.example.ficha8.models.Andar;
import com.example.ficha8.repository.AndarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AndarService {
    private final AndarRepository andarRepository;

    public AndarService(AndarRepository andarRepository) {
        this.andarRepository = andarRepository;
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
        if (andarRepository.findById(id).isEmpty()){
            return false;
        }

        andarRepository.deleteById(id);
        return true;
    }
}
