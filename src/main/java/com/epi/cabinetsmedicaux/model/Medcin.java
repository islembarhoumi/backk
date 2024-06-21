package com.epi.cabinetsmedicaux.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    public class Medcin extends User {


    private int experience;

    private String specialite;
    private String assignement;

    public Medcin(int id ){

        this.setId((long) id);
    }

    @OneToMany(mappedBy = "medcin", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    @ManyToOne
    @JoinColumn(name = "dossierMedical_id")
    private DossierMedical dossierMedical;


    @OneToOne
    @JoinColumn(name = "cabinet_id")
    private Cabinet cabinet;

    @OneToMany(mappedBy = "medcin", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RendezVous> rendezVousList;



    @ManyToMany
    @JoinTable(name = "medcin_patient",
            joinColumns = @JoinColumn(name = "medcin_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> patients;



    @OneToOne
    @JoinColumn(name = "secretaire", referencedColumnName = "id")
    private Secretaire secretaire;





    public Medcin() {

    }


    public Medcin(String nom, String prenom, String email, String password, String adresse, String telephone, String specialite, int experience) {
        super( nom,  prenom,  email,  password,  adresse,  telephone);
        this.experience = experience;
        this.specialite = specialite;

    }
}








