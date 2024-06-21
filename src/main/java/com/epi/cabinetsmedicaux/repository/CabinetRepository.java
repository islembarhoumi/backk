package com.epi.cabinetsmedicaux.repository;

import com.epi.cabinetsmedicaux.model.Cabinet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinetRepository extends CrudRepository<Cabinet, Long>{

}