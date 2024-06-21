
package com.epi.cabinetsmedicaux.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@Entity
public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adresse;
    private int numTel;
    private Date horraire;




    @OneToMany(mappedBy ="cabinet", cascade = CascadeType.ALL)
    private List<Salle> salles;


    @OneToOne(mappedBy ="cabinet", cascade = CascadeType.ALL)
    private Medcin medcin;




    @OneToMany(mappedBy ="cabinet", cascade = CascadeType.ALL)
    private List<Secretaire> secretaires;




    public Cabinet() {
        // Constructeur par défaut
    }

    public Cabinet( String adresse, Integer numTel, Date horraire) {

        this.adresse = adresse;
        this.numTel= numTel;
        this.horraire = horraire;

    }
}

