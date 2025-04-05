package com.example.demo.Controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.salvarCliente(cliente));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Optional<Cliente>> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clienteService.buscarClientePorCpf(cpf));
    }

    @GetMapping("/celular/{celular}")
    public ResponseEntity<Optional<Cliente>> buscarPorCelular(@PathVariable String celular) {
        return ResponseEntity.ok(clienteService.buscarClientePorCelular(celular));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }
}

