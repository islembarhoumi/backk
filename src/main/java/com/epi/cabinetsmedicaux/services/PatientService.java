package com.epi.cabinetsmedicaux.services;


import com.epi.cabinetsmedicaux.model.Patient;
import com.epi.cabinetsmedicaux.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



    @Service
    public class PatientService{

        private final PatientRepository patientRepository;

        public PatientService(PatientRepository patientRepository) {
            this.patientRepository = patientRepository;
        }


        public List<Patient> getAllPatient() {
            return (List<Patient>) patientRepository.findAll();
        }

        public Optional<Patient> getPatientById(Long id) {
            return patientRepository.findById(id);
        }

        public Patient savePatient(Patient patient) {
            return patientRepository.save(patient);
        }

        public void deletePatient(Long id) {
            patientRepository.deleteById(id);
        }}
















