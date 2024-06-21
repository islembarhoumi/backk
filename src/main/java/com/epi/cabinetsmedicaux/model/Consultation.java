package com.epi.cabinetsmedicaux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Consultation { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


private Long id;

   private String nomPatient;
    private Date date;


    @ManyToOne
    @JoinColumn(name ="medcin_id")
    private Medcin medcin;

    @OneToOne(mappedBy ="consultation", cascade = CascadeType.ALL)
    private RendezVous rendezVous;




    public Consultation() {
        // Constructeur par défaut
    }


}


