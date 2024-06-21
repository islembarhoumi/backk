package com.epi.cabinetsmedicaux.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@AllArgsConstructor

public class Inscription {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String email;
    private String password;
    private String role;
    private String specialite;
    private int experience;
    private String maladie;
    private String allergie ;
    private int anneeExperience;
}
