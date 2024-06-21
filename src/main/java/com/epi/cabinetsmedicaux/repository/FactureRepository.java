package com.epi.cabinetsmedicaux.repository;

import com.epi.cabinetsmedicaux.model.Consultation;
import com.epi.cabinetsmedicaux.model.Facture;
import com.epi.cabinetsmedicaux.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FactureRepository extends CrudRepository<Facture, Long>{

}
