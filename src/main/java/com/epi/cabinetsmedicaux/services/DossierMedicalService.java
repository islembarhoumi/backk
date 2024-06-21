package com.epi.cabinetsmedicaux.services;

import com.epi.cabinetsmedicaux.model.Cabinet;
import com.epi.cabinetsmedicaux.model.DossierMedical;
import com.epi.cabinetsmedicaux.repository.CabinetRepository;
import com.epi.cabinetsmedicaux.repository.DossierMedicalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DossierMedicalService {private DossierMedicalRepository dossierMedicalRepository;



    public DossierMedicalService(DossierMedicalRepository dossierMedicalRepository) {
        this.dossierMedicalRepository = dossierMedicalRepository;
    }

    public List<DossierMedical> getAllDossierMedical() {
        return (List<DossierMedical>) dossierMedicalRepository.findAll();
    }

    public Optional<DossierMedical> getDossierMedicalById(Long id) {
        return dossierMedicalRepository.findById(id);
    }

    public DossierMedical saveDossierMedical(DossierMedical dossierMedical) {
        return dossierMedicalRepository.save(dossierMedical);
    }
    public void deleteDossierMedical(Long id) {
        dossierMedicalRepository.deleteById(id);
    }
}



