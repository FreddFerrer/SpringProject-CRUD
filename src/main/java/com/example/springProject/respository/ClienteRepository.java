package com.example.springProject.respository;

import com.example.springProject.models.ClienteModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long >{



}
