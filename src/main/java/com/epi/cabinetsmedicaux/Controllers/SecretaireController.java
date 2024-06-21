package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.Secretaire;
import com.epi.cabinetsmedicaux.services.SecretaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.epi.cabinetsmedicaux.model.Medcin;
import com.epi.cabinetsmedicaux.services.MedcinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/secretaires")
public class SecretaireController {


    private SecretaireService secretaireService;

    public  SecretaireController (SecretaireService secretaireService) {
        this.secretaireService= secretaireService;
    }


    @GetMapping("/list")
    public List<Secretaire> getAllSecretaires() {
        return secretaireService.getAllSecretaire();
    }

    @GetMapping("/{id}")
    public Optional<Secretaire> getSecretaireById(@PathVariable Long id) {
        return secretaireService.getSecretaireById(id);
    }

    @PostMapping("/saveSecretaire")
    public Secretaire saveSecretaire(@RequestBody Secretaire secretaire) {
        return secretaireService.saveSecretaire(secretaire);
    }

    @DeleteMapping("/{id}")
    public void deleteSecretaire(@PathVariable Long id) {
        secretaireService.deleteSecretaire(id);
    }







    @PutMapping("/{id}")
    public ResponseEntity<Secretaire> updateMedecin(@PathVariable Long id, @RequestBody Secretaire updatedSecretaire) {
        Optional<Secretaire> existingMedecin = secretaireService.getSecretaireById(id);

        if (existingMedecin.isPresent()) {
            Secretaire secretaireToUpdate = existingMedecin.get();
            // Mettez à jour les propriétés nécessaires du médecin existant avec les nouvelles valeurs
            secretaireToUpdate.setNom(updatedSecretaire.getNom());
            secretaireToUpdate.setPrenom(updatedSecretaire.getPrenom());
            // Ajoutez d'autres propriétés que vous souhaitez mettre à jour

            // Enregistrez le médecin mis à jour
            Secretaire updatedSecretaireResult = secretaireService.saveSecretaire(secretaireToUpdate);

            return ResponseEntity.ok(updatedSecretaireResult);
        } else {
            // Retournez une réponse 404 (Not Found) si le médecin n'est pas trouvé
            return ResponseEntity.notFound().build();
        }
    }




}
