package br.com.goingtomaster.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goingtomaster.model.Cliente;
import br.com.goingtomaster.repository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")

public class ClienteController {
    @Autowired
    private ClienteRepository _repositoryCliente;

    @GetMapping
    public List<Cliente> obter() {
        return this._repositoryCliente.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obter(@PathVariable("id") Long id) {
        return this._repositoryCliente.findById(id);
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return this._repositoryCliente.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return this._repositoryCliente.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        this._repositoryCliente.deleteById(id);
    }
}
