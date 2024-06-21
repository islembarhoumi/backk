package com.epi.cabinetsmedicaux.services;

import com.epi.cabinetsmedicaux.model.Salle;
import com.epi.cabinetsmedicaux.repository.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SalleService {
    private SalleRepository salleRepository;

    public void SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> getAllSalles() {
        return (List<Salle>) salleRepository.findAll();
    }

    public Optional<Salle> getSalleById(Long id) {
        return salleRepository.findById(id);
    }

    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    public void deletesalle(Long id) {
        salleRepository.deleteById(id);
    }
}








