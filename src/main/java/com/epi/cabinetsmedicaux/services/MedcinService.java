package com.epi.cabinetsmedicaux.services;

import com.epi.cabinetsmedicaux.model.Medcin;
import com.epi.cabinetsmedicaux.model.Secretaire;
import com.epi.cabinetsmedicaux.repository.MedcinRepository;
import com.epi.cabinetsmedicaux.repository.SecretaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MedcinService{


    @Autowired
    private SecretaireRepository secretaireRepository;

    private final MedcinRepository medcinRepository;

    public MedcinService(MedcinRepository medcinRepository) {
        this.medcinRepository = medcinRepository;
    }


    public List<Medcin> getAllMedcins() {
        return (List<Medcin>) medcinRepository.findAll();
    }

    public Optional<Medcin> getMedcinById(Long id) {
        return medcinRepository.findById(id);
    }

    public Medcin saveMedcin(Medcin medcin) {
        return medcinRepository.save(medcin);
    }

    public void deleteMedcin(Long id) {
        medcinRepository.deleteById(id);
    }




    public Medcin findMedcinByEmail(String email) {
        return (Medcin) medcinRepository.findByEmail(email);
    }

    public Medcin findById(Long id) {
        return medcinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medcin not found"));
    }

    public void assignSecretaire(Long medcinId, Long secretaireId) {
        Medcin medcin = findById(medcinId);
        Secretaire secretaire = secretaireRepository.findById(secretaireId)
                .orElseThrow(() -> new RuntimeException("Secretaire not found"));

        medcin.setSecretaire(secretaire);
        medcinRepository.save(medcin);
    }



    public Medcin getMedecinById(Long id) {
        return medcinRepository.findById(id).orElse(null);
    }


}


