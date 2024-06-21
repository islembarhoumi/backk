package com.epi.cabinetsmedicaux.repository;

import com.epi.cabinetsmedicaux.model.DossierMedical;
import com.epi.cabinetsmedicaux.model.Patient;
import com.epi.cabinetsmedicaux.model.RendezVous;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RendezVousRepository  extends CrudRepository<RendezVous, Long> {


}
