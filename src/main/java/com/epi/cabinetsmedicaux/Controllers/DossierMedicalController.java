package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.DossierMedical;
import com.epi.cabinetsmedicaux.services.DossierMedicalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class DossierMedicalController {

    private final DossierMedicalService dossierMedicalService;

    public DossierMedicalController(DossierMedicalService dossierMedicalService) {
        this.dossierMedicalService = dossierMedicalService;
    }



    @GetMapping
    public List<DossierMedical> getAllDossierMedical() {
        return dossierMedicalService.getAllDossierMedical();
    }

    @GetMapping("/{id}")
    public Optional<DossierMedical> getDossierMedicalById(@PathVariable Long id) {
        return dossierMedicalService.getDossierMedicalById(id);
    }

    @PostMapping("/saveUser")
    public DossierMedical saveDossierMedical(@RequestBody DossierMedical dossiermedicale) {
        return dossierMedicalService.saveDossierMedical(dossiermedicale);
    }

    @DeleteMapping("/{id}")
    public void deleteDossierMedical(@PathVariable Long id) {
        dossierMedicalService.deleteDossierMedical(id);
    }


}

