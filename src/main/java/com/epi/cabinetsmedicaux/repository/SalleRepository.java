package com.epi.cabinetsmedicaux.repository;


import com.epi.cabinetsmedicaux.model.Cabinet;
import com.epi.cabinetsmedicaux.model.Patient;
import com.epi.cabinetsmedicaux.model.Salle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SalleRepository extends CrudRepository<Salle, Long> {

}
