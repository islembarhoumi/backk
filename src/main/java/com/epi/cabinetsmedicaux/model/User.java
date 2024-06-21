package com.epi.cabinetsmedicaux.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//  Les attributs hérités sont répétés dans chaque table.
//@DiscriminatorColumn(name = "usertype")//
@Getter
@Setter
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String email;
    private String password;



    public User() {

    }

    public User(String nom, String prenom, String email, String password, String adresse, String telephone) {
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.password=password;
        this.adresse=adresse;
        this.telephone=telephone;

    }


    public void hashPassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }
    // Getters and setters for private fields (not shown in your provided code)

}
