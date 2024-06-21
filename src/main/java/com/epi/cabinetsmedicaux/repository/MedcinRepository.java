package com.epi.cabinetsmedicaux.repository;

import com.epi.cabinetsmedicaux.model.Medcin;
import com.epi.cabinetsmedicaux.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedcinRepository  extends CrudRepository<Medcin, Long> {








    Medcin findByEmail(String email);



}
