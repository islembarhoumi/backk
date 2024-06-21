package com.epi.cabinetsmedicaux.Controllers;

import com.epi.cabinetsmedicaux.model.Connexion;
import com.epi.cabinetsmedicaux.model.Inscription;
import com.epi.cabinetsmedicaux.model.Medcin;
import com.epi.cabinetsmedicaux.model.Secretaire;
import com.epi.cabinetsmedicaux.repository.MedcinRepository;
import com.epi.cabinetsmedicaux.repository.PatientRepository;
import com.epi.cabinetsmedicaux.services.InscriptionService;
import com.epi.cabinetsmedicaux.services.MedcinService;
import com.epi.cabinetsmedicaux.services.SecretaireService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/inscription")
@CrossOrigin(origins = "http://localhost:4200")
public class InscriptionController {


    @Autowired
    private InscriptionService inscriptionService;
    private MedcinService medcinService;


    public InscriptionController
            (InscriptionService inscriptionService ,  MedcinService medcinService ){
        this.inscriptionService=inscriptionService ;
        this.medcinService=medcinService ;

    }

    @PostMapping
    public ResponseEntity<String> inscrireUtilisateur(@RequestBody Inscription inscription) {
        inscriptionService.inscrireUtilisateur(inscription);
        return ResponseEntity.ok("Inscription réussie.");
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> connecterUtilisateur(@RequestBody Connexion connexion, HttpSession session) {
        // Ajouter la logique de connexion
        Connexion connexionAvecDetails = inscriptionService.connecterUtilisateurr(connexion);

        if (connexionAvecDetails.getRole() != null) {
            // Stockez l'identifiant de session dans votre objet ConnexionDTO
            connexionAvecDetails.setSessionId(session.getId());

            // Construire la réponse avec les détails de l'utilisateur
            Map<String, Object> response = new HashMap<>();
            response.put("success", "true");
            response.put("role", connexionAvecDetails.getRole());
            response.put("sessionId", session.getId()); // Ajoutez l'identifiant de session à la réponse

            // Ajoutez les détails spécifiques à l'utilisateur (patient, médecin ou secrétaire)
            response.put("id", connexionAvecDetails.getId());
            response.put("email", connexionAvecDetails.getEmail());
            response.put("nom", connexionAvecDetails.getNom());
            response.put("prenom", connexionAvecDetails.getPrenom());
            response.put("telephone", connexionAvecDetails.getTelephone());
            response.put("adresse", connexionAvecDetails.getAdresse());

            // Ajoutez les détails supplémentaires selon le rôle
            if (connexionAvecDetails.getRole().equals("medecin")) {
                response.put("specialite", connexionAvecDetails.getSpecialite());
                response.put("experience", connexionAvecDetails.getExperience());
                response.put("assignement", connexionAvecDetails.getAssignement());

                // Récupérer les détails du secrétaire associé à ce médecin
                Medcin medecin = medcinService.getMedecinById(connexionAvecDetails.getId());
                if (medecin != null && medecin.getSecretaire() != null) {
                    Secretaire secretaire = medecin.getSecretaire();
                    response.put("secretaire", Map.of(
                            "id", secretaire.getId(),
                            "nom", secretaire.getNom(),
                            "prenom", secretaire.getPrenom(),
                            "anneeExperience", secretaire.getAnneeExperience()
                            // Ajoutez d'autres détails du secrétaire au besoin
                    ));
                }
            } else if (connexionAvecDetails.getRole().equals("patient")) {
                response.put("maladie", connexionAvecDetails.getMaladie());
            } else if (connexionAvecDetails.getRole().equals("secretaire")) {
                response.put("anneeExperience", connexionAvecDetails.getAnneeExperience());
            }

            return ResponseEntity.ok(response);
        } else {
            // Si la connexion échoue, renvoyer une réponse avec succès false
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            return ResponseEntity.badRequest().body(response);
        }
    }

}