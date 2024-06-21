package com.epi.cabinetsmedicaux.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor

public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private LocalTime heure;
    private String statut;
    private String etat ;


    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "medcin")
    @JsonBackReference
    private Medcin medcin;

    @OneToOne
    @JoinColumn(name ="consultation_id")
    private Consultation consultation;







    public RendezVous() {

    }
}
