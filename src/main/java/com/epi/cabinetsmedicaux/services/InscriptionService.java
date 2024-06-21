package com.epi.cabinetsmedicaux.services;

import com.epi.cabinetsmedicaux.model.*;
import com.epi.cabinetsmedicaux.repository.MedcinRepository;
import com.epi.cabinetsmedicaux.repository.PatientRepository;
import com.epi.cabinetsmedicaux.repository.SecretaireRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InscriptionService {

    @Autowired
    private MedcinRepository medcinRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SecretaireRepository secretaireRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public InscriptionService(MedcinRepository medcinRepository, PatientRepository patientRepository, SecretaireRepository secretaireRepository) {
        this.medcinRepository = medcinRepository;
        this.patientRepository = patientRepository;
        this.secretaireRepository = secretaireRepository;
    }

    public void inscrireUtilisateur(Inscription inscription) {
        if ("medecin".equalsIgnoreCase(inscription.getRole())) {
            inscrireMedcin(inscription);
        } else if ("patient".equalsIgnoreCase(inscription.getRole())) {
            inscrirePatient(inscription);
        } else if ("secretaire".equalsIgnoreCase(inscription.getRole())) {
            inscrireSecretaire(inscription);
        } else {
            throw new IllegalArgumentException("Rôle non valide pour l'inscription.");
        }
    }

    private void inscrirePatient(Inscription inscription) {
        Patient patient = new Patient(inscription.getNom(), inscription.getPrenom(), inscription.getEmail(),
                inscription.getAdresse(), inscription.getTelephone(), passwordEncoder.encode(inscription.getPassword()),
                inscription.getMaladie(), inscription.getAllergie());

        patientRepository.save(patient);
    }

    private void inscrireMedcin(Inscription inscription) {
        Medcin medcin = new Medcin(inscription.getNom(), inscription.getPrenom(),
                inscription.getEmail(), passwordEncoder.encode(inscription.getPassword()),
                inscription.getAdresse(), inscription.getTelephone(),
                inscription.getSpecialite(), inscription.getExperience());

        medcinRepository.save(medcin);
    }

    private void inscrireSecretaire(Inscription inscription) {
        Secretaire secretaire = new Secretaire(inscription.getNom(), inscription.getPrenom(),
                inscription.getEmail(), passwordEncoder.encode(inscription.getPassword()),
                inscription.getAdresse(), inscription.getTelephone(),
                inscription.getAnneeExperience());

        secretaireRepository.save(secretaire);
    }

    public Connexion connecterUtilisateur(Connexion connexion) {
        // Ajouter la logique de connexion ici
        // Vérifier les informations d'identification, comparer les mots de passe, etc.
        Medcin medecin = medcinRepository.findByEmail(connexion.getEmail());
        if (medecin != null && passwordEncoder.matches(connexion.getPassword(), medecin.getPassword())) {
            connexion.setRole("medecin");
            return connexion;
        }

        Patient patient = patientRepository.findByEmail(connexion.getEmail());
        if (patient != null && passwordEncoder.matches(connexion.getPassword(), patient.getPassword())) {
            connexion.setRole("patient");
            return connexion;
        }


        Secretaire secretaire = secretaireRepository.findByEmail(connexion.getEmail());
        if (secretaire != null && passwordEncoder.matches(connexion.getPassword(), secretaire.getPassword())) {
            connexion.setRole("secretaire");
            return connexion;
        }

        // Aucune correspondance trouvée, retourner l'objet ConnexionDTO sans le rôle
        return connexion;
    }

    public Connexion connecterUtilisateurr(Connexion connexion) {
        // Ajouter la logique de connexion ici
        // Vérifier les informations d'identification, comparer les mots de passe, etc.
        Medcin medcin = medcinRepository.findByEmail(connexion.getEmail());
        if (medcin != null && passwordEncoder.matches(connexion.getPassword(), medcin.getPassword())) {
            connexion.setRole("medecin");
            connexion.setEmail(medcin.getEmail());
            connexion.setNom(medcin.getNom());
            connexion.setTelephone(medcin.getTelephone());
            connexion.setId(medcin.getId());
            connexion.setSpecialite(medcin.getSpecialite());
            connexion.setAdresse(medcin.getAdresse());
            connexion.setExperience(medcin.getExperience()
            );
            connexion.setAssignement(medcin.getAssignement());
            return connexion;
        }

        Patient patient = patientRepository.findByEmail(connexion.getEmail());
        if (patient != null && passwordEncoder.matches(connexion.getPassword(), patient.getPassword())) {
            connexion.setRole("patient");
            connexion.setEmail(patient.getEmail());
            connexion.setId(patient.getId());
            connexion.setMaladie(patient.getMaladie());
            connexion.setNom(patient.getNom());
            connexion.setAdresse(patient.getAdresse());
            connexion.setPrenom(patient.getPrenom());
            return connexion;
        }

        Secretaire secretaire = secretaireRepository.findByEmail(connexion.getEmail());
        if (secretaire != null && passwordEncoder.matches(connexion.getPassword(), secretaire.getPassword())) {
            connexion.setRole("secretaire");
            connexion.setEmail(secretaire.getEmail());
            connexion.setId(secretaire.getId());
            connexion.setAnneeExperience(secretaire.getAnneeExperience());
            connexion.setNom(secretaire.getNom());
            connexion.setPrenom(secretaire.getPrenom());
            connexion.setAdresse(secretaire.getAdresse());
            return connexion;
        }


        // Aucune correspondance trouvée, retourner l'objet ConnexionDTO sans le rôle
        return connexion;
    }

}


