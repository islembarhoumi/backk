package com.epi.cabinetsmedicaux.repository;

import com.epi.cabinetsmedicaux.model.Consultation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends CrudRepository<Consultation, Long> {

}
