package com.epi.cabinetsmedicaux.services;

import com.epi.cabinetsmedicaux.model.Patient;
import com.epi.cabinetsmedicaux.model.Secretaire;
import com.epi.cabinetsmedicaux.repository.PatientRepository;
import com.epi.cabinetsmedicaux.repository.SecretaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SecretaireService {private final SecretaireRepository secretaireRepository;

    public SecretaireService(SecretaireRepository secretaireRepository) {
        this.secretaireRepository= secretaireRepository;
    }


    public List<Secretaire> getAllSecretaire() {
        return (List<Secretaire>)secretaireRepository.findAll();
    }

    public Optional<Secretaire> getSecretaireById(Long id) {
        return secretaireRepository.findById(id);
    }

    public Secretaire saveSecretaire(Secretaire secretaire) {
        return secretaireRepository.save(secretaire);
    }

    public void deleteSecretaire(Long id) {
        secretaireRepository.deleteById(id);
    }

    public void save(Secretaire secretaire) {
    }







}





