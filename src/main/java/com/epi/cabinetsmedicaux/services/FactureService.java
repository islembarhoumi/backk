package com.epi.cabinetsmedicaux.services;

import com.epi.cabinetsmedicaux.model.Facture;
import com.epi.cabinetsmedicaux.model.Medcin;
import com.epi.cabinetsmedicaux.repository.FactureRepository;
import com.epi.cabinetsmedicaux.repository.MedcinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FactureService {
    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }


    public List<Facture> getAllFactures() {
        return (List<Facture>) factureRepository.findAll();
    }

    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }











}

