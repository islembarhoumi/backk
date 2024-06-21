package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.Consultation;
import com.epi.cabinetsmedicaux.services.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Consultation")


public class ConsultationController {
    private final ConsultationService ConsultationService;
    

    public ConsultationController(ConsultationService ConsultationService) {
        this.ConsultationService = ConsultationService;
    }


    @GetMapping
    public List<Consultation> getAllConsultations() {
        return ConsultationService.getAllConsultation();
    }

    @GetMapping("/{id}")
    public Optional<Consultation> getConsultationById(@PathVariable Long id) {
        return ConsultationService.getConsultationById(id);
    }

    @PostMapping("/saveConsultation")
    public Consultation saveConsultation(@RequestBody Consultation consultation) {
        return ConsultationService.saveConsultation(consultation);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultation(@PathVariable Long id) {
        ConsultationService.deleteConsultation(id);
    }


}


