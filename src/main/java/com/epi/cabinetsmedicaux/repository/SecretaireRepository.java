package com.epi.cabinetsmedicaux.repository;

import com.epi.cabinetsmedicaux.model.Patient;
import com.epi.cabinetsmedicaux.model.Secretaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SecretaireRepository  extends CrudRepository<Secretaire, Long> {


    Secretaire findByEmail(String email);
}


