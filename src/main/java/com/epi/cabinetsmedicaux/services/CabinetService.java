package com.epi.cabinetsmedicaux.services;

import com.epi.cabinetsmedicaux.model.Cabinet;
import com.epi.cabinetsmedicaux.repository.CabinetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CabinetService {



    private final CabinetRepository cabinetRepository;

    public CabinetService(CabinetRepository cabinetRepository) {
        this.cabinetRepository = cabinetRepository;
    }

    public List<Cabinet> getAllCabinets() {
        return (List<Cabinet>) cabinetRepository.findAll();
    }

    public Optional<Cabinet> getCabinetById(Long id) {
        return cabinetRepository.findById(id);
    }

    public Cabinet saveCabinet(Cabinet cabinet) {
        return cabinetRepository.save(cabinet);
    }

    public void deleteCabinet(Long id) {
        cabinetRepository.deleteById(id);
    }


}


















