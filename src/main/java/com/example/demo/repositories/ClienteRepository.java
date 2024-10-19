package com.example.demo.repositories;

import com.example.demo.models.ClienteModel;
import com.example.demo.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {
}

