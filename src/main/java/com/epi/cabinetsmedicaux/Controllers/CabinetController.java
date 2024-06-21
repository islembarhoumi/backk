package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.Cabinet;

import com.epi.cabinetsmedicaux.services.CabinetService;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cabinets")
public class CabinetController {


    private final CabinetService cabinetService;

    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }


    @GetMapping
    public List<Cabinet> getAllCabinets() {
        return cabinetService.getAllCabinets();
    }

    @GetMapping("/{id}")
    public Optional<Cabinet> getCabinetById(@PathVariable Long id) {
        return cabinetService.getCabinetById(id);
    }

    @PostMapping("/saveCabinet")
    public Cabinet saveCabinet(@RequestBody Cabinet cabinet) {
        return cabinetService.saveCabinet(cabinet);
    }

    @DeleteMapping("/{id}")
    public void deleteCabinet(@PathVariable Long id) {
        cabinetService.deleteCabinet(id);
    }


}
