package com.epi.cabinetsmedicaux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@AllArgsConstructor
public class Secretaire  extends User {


    private int anneeExperience;

    @ManyToOne
    @JoinColumn(name ="cabinet_id")
    private Cabinet cabinet;







    public Secretaire() {

    }


    public Secretaire(String nom, String prenom, String email, String password, String adresse, String telephone,int anneeExperience) {
        super( nom,  prenom,  email,  password,  adresse,  telephone);
        this.anneeExperience = anneeExperience;


    }
}







