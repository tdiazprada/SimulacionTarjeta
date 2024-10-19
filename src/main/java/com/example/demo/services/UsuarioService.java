package com.example.demo.services;

import com.example.demo.models.ClienteModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerCliente(){
       return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }
}




