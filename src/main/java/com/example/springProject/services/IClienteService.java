package com.example.springProject.services;

import com.example.springProject.models.ClienteModel;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<ClienteModel> listarClientes();
    void guardarCliente(ClienteModel cliente);
    void eliminarCliente(Long id);
    Optional<ClienteModel> buscarClienteById(Long id);

    Boolean comprobarExistencia(Long id);



}
