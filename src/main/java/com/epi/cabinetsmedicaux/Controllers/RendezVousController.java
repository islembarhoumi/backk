package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.RendezVous;
import com.epi.cabinetsmedicaux.model.Secretaire;
import com.epi.cabinetsmedicaux.services.RendezVousService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.CallableStatement;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/rendezvous")
@CrossOrigin(origins = "http://localhost:4200")
public class RendezVousController {
    private final RendezVousService rendezVousService;

    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }


    @GetMapping
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    @GetMapping("/{id}")
    public Optional<RendezVous> getRendezVousById(@PathVariable Long id) {
        return rendezVousService.getRendezVousById(id);
    }

    @PostMapping("/save")
    public RendezVous saveRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.saveRendezVous(rendezVous);
    }

    @DeleteMapping("/{id}")
    public void deleteRendezVous(@PathVariable Long id) {
        rendezVousService.deleteRendezVous(id);
    }



    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> updateRendezVvous(@PathVariable Long id, @RequestBody RendezVous updatedRendezvous) {
        Optional<RendezVous> existingRendezvous = rendezVousService.getRendezvousById(id);

        if (existingRendezvous.isPresent()) {
            RendezVous rendezVousToUpdate = existingRendezvous.get();
            // Mettez à jour les propriétés nécessaires du médecin existant avec les nouvelles valeurs
            rendezVousToUpdate.setDate(updatedRendezvous.getDate());
            rendezVousToUpdate.setStatut(updatedRendezvous.getStatut());

            // Ajoutez d'autres propriétés que vous souhaitez mettre à jour

            // Enregistrez le médecin mis à jour
            RendezVous updatedRendezVousResult = rendezVousService.saveRendezVous(rendezVousToUpdate);

            return ResponseEntity.ok(updatedRendezVousResult);
        } else {
            // Retournez une réponse 404 (Not Found) si le médecin n'est pas trouvé
            return ResponseEntity.notFound().build();
        }
    }

}


