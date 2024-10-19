package com.example.demo.services;

import com.example.demo.models.ClienteModel;
import com.example.demo.models.SimulacionModel;
import com.example.demo.models.SimulacionRqDTO;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.SimulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SimulacionService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SimulacionRepository simulacionRepository;


    @Transactional
    public ClienteModel registarCliente(ClienteModel client){
        ClienteModel clientnew =  clienteRepository.save(client);
        System.out.println("clientnew.getId() = " + clientnew.getId());
        return clientnew;
    }
    @Transactional
    public void eliminarCliente(Long clientId) {
        if (clienteRepository.existsById(clientId)) {
            clienteRepository.deleteById(clientId);
            System.out.println("Cliente con ID " + clientId + " ha sido eliminado.");
        } else {
            System.out.println("Cliente con ID " + clientId + " no encontrado.");
        }
    }


    @Transactional
    public ResponseEntity<SimulacionModel> realizarSimulación (SimulacionRqDTO simulacionRequest) {

        try {
            ClienteModel client = new ClienteModel(
                    simulacionRequest.getNombre(),
                    simulacionRequest.getEmail(),
                    simulacionRequest.getCedula(),
                    simulacionRequest.getTelefono());

            ClienteModel clientnew =  clienteRepository.save(client);

            System.out.println("clientid = " + clientnew.getId());

            SimulacionModel simulacionTable = new SimulacionModel();
            simulacionTable.setCupoAprobado(simulacionRequest.getSalario() * 2);
            simulacionTable.setTasa("10");
            simulacionTable.setTipoTarjeta("Tarjeta gold");
            simulacionTable.setClienteId((long) 20);
            simulacionTable.setSalario(simulacionRequest.getSalario());

            System.out.println("simulacionTable.toString() = " + simulacionTable.toString());

            simulacionRepository.save(simulacionTable);

            return ResponseEntity.ok(simulacionTable);
        } catch (Exception e ) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error en simulación", e);
        }

    }
}





