package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.Medcin;
import com.epi.cabinetsmedicaux.services.MedcinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/medcin")

public class MedcinController {

    private final MedcinService medcinService;

    public MedcinController(MedcinService medcinService) {
        this.medcinService = medcinService;
    }



    @GetMapping("/list")
    public List<Medcin> getAllMedcin() {
        return medcinService.getAllMedcins();
    }

    @GetMapping("/{id}")
    public Optional<Medcin> getMedcinById(@PathVariable Long id) {
        return medcinService.getMedcinById(id);
    }


    @PostMapping("/saveMedcin")
    public Medcin saveMedcin(@RequestBody Medcin medcin)
            {
        return medcinService.saveMedcin(medcin);
    }

    @DeleteMapping("/{id}")
    public void deleteMedcin(@PathVariable Long id) {
       medcinService.deleteMedcin(id);
    }


    @PostMapping("/{medcinId}/assignSecretaire/{secretaireId}")
    public ResponseEntity<Void> assignSecretaireToMedcin(
            @PathVariable Long medcinId, @PathVariable Long secretaireId) {
        medcinService.assignSecretaire(medcinId, secretaireId);
        return ResponseEntity.ok().build();
    }




}

