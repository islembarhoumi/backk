package com.epi.cabinetsmedicaux.services;

import com.epi.cabinetsmedicaux.model.Cabinet;
import com.epi.cabinetsmedicaux.model.Consultation;
import com.epi.cabinetsmedicaux.model.DossierMedical;
import com.epi.cabinetsmedicaux.repository.CabinetRepository;
import com.epi.cabinetsmedicaux.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ConsultationService {private ConsultationRepository consultationRepository;


    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }
    public List<Consultation> getAllConsultation() {
        return (List<Consultation>) consultationRepository.findAll();
    }

    public Optional<Consultation> getConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }


}

