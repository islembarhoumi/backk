package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.Medcin;
import com.epi.cabinetsmedicaux.model.Salle;
import com.epi.cabinetsmedicaux.services.MedcinService;
import com.epi.cabinetsmedicaux.services.SalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/salle")
public class SalleController {private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }




    @GetMapping
    public List<Salle> getAllSalle() {
        return salleService.getAllSalles();
    }
    @GetMapping("/{id}")
    public Optional< Salle> getSalleById(@PathVariable Long id) {
        return  salleService.getSalleById(id);
    }


    @PostMapping("/saveSalle")
    public Salle saveSalle(@RequestBody Salle salle)
    {
        return salleService.saveSalle(salle);
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable Long id) {salleService.deletesalle(id);
    }


}












