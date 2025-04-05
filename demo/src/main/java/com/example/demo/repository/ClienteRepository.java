package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    
    Optional<Cliente> findByCpf(String cpf);

    
    Optional<Cliente> findByCelular(String celular);
}
