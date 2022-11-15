package com.example.springProject.services;

import com.example.springProject.models.CiudadModel;
import com.example.springProject.respository.CiudadRepository;
import com.example.springProject.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImplement implements ICiudadService{

    @Autowired
    private CiudadRepository ciudadRepository;


    @Override
    public List<CiudadModel> listarCiudades() {
        return (List<CiudadModel>) ciudadRepository.findAll();
    }


}
