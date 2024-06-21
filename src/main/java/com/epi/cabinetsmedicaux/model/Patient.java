package com.epi.cabinetsmedicaux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient  extends User {

    private String maladie;
    private String allergie ;

    @OneToMany(mappedBy ="patient", cascade = CascadeType.ALL)
    private List<Facture> factures;



    @ManyToMany(mappedBy ="patients")
    private Set<Medcin> medcins;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Avis> avisList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<RendezVous> rendezVousList;

    public Patient(String nom, String prenom, String email, String adresse, String telephone, String password, String maladie, String allergie) {

        super( nom,  prenom,  email,  password,  adresse,  telephone);
        this.maladie = maladie;
        this.allergie = allergie;

    }
}










