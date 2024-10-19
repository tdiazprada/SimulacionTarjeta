package com.example.demo.controllers;

import com.example.demo.models.ClienteModel;
import com.example.demo.models.SimulacionModel;
import com.example.demo.models.SimulacionRqDTO;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.SimulacionService;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "*", // Permite todos los orígenes
        allowedHeaders = "*", // Headers permitidos
        allowCredentials = "false") // No permite credenciales con todos los orígenes

@RequestMapping("/tarjeta")
public class TarjetaController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    SimulacionService simulacionService;

    @GetMapping("consulta")
    public ArrayList<ClienteModel> obtenerCliente(){
        return usuarioService.obtenerCliente();

    }
    @DeleteMapping("/eliminar-cliente/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long id) {
        simulacionService.eliminarCliente(id);
        return ResponseEntity.ok("Cliente con ID " + id + " ha sido eliminado.");
    }

    @PostMapping("/registrar-cliente")
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        return this.simulacionService.registarCliente(cliente);
    }

    @PostMapping("/simulacion")
    public ResponseEntity<SimulacionModel> realizarSimulación(@RequestBody SimulacionRqDTO simulacion) {
        return this.simulacionService.realizarSimulación(simulacion);
    }
}




