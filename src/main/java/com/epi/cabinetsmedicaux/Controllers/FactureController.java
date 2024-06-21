package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.Facture;
import com.epi.cabinetsmedicaux.services.FactureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class FactureController {
    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }



    @GetMapping
    public List<Facture> getAllFacture() {
        return factureService.getAllFactures();
    }
    @GetMapping("/{id}")
    public Optional< Facture> getFactureById(@PathVariable Long id) {
        return  factureService.getFactureById(id);
    }



    @PostMapping("/saveFacture")
    public Facture saveFacture(@RequestBody Facture facture)
    {
        return factureService.saveFacture(facture);
    }

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id) {
       factureService.deleteFacture(id);
    }





}


