package com.epi.cabinetsmedicaux.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connexion {

    private Long id;
    private String email;
    private String password;
    private String nom;
    private String sessionId;
    private String prenom;
    private String telephone;
    private String adresse;
    private String role;
    private String maladie;
    private String allergie;
    private String specialite;
    private int anneeExperience;
    private String assignement;
    private int experience ;


}


