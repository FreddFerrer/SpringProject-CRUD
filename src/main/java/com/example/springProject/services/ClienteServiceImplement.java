package com.example.springProject.services;

import com.example.springProject.models.ClienteModel;
import com.example.springProject.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImplement implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> listarClientes() {
        return (List<ClienteModel>) clienteRepository.findAll();
    }

    @Override
    public void guardarCliente(ClienteModel cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        } else{
            System.out.println("cliente no encontrado");
        }
    }

    @Override
    public Optional<ClienteModel> buscarClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Boolean comprobarExistencia(Long id) {
        if (clienteRepository.existsById(id)){
            return true;
        } else {
            return false;
        }
    }
}
