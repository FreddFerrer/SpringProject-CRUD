package com.example.springProject.respository;

import com.example.springProject.models.CiudadModel;
import org.springframework.data.repository.CrudRepository;

public interface CiudadRepository extends CrudRepository<CiudadModel, Long> {
}
