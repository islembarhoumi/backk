package com.epi.cabinetsmedicaux.repository;

import com.epi.cabinetsmedicaux.model.Cabinet;
import com.epi.cabinetsmedicaux.model.DossierMedical;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicalRepository  extends CrudRepository<DossierMedical, Long> {







}
