package br.com.goingtomaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.goingtomaster.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Optional<Cliente> findById (Long id);
    
}
