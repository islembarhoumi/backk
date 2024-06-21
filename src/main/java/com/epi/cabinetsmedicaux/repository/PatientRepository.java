package com.epi.cabinetsmedicaux.repository;

import com.epi.cabinetsmedicaux.model.Medcin;
import com.epi.cabinetsmedicaux.model.Patient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {


    Patient findByEmail(String email);
}
