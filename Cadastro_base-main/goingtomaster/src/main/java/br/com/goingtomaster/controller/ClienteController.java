package br.com.goingtomaster.controller;

import java.util.List;
import java.util.Optional;
import java.lang.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import br.com.goingtomaster.model.Produto;
import br.com.goingtomaster.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/cliente")

public class ClienteController {
    @Autowired
    private ClienteRepository _repositoryCliente;

    @GetMapping
    @ResponseStatus (code = HttpStatus.OK)
    public List<Cliente> obter() {
        try {
            return this._repositoryCliente.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                'Produto não encontrado',
                e
            );
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus (code = HttpStatus.OK)
    public Optional<Cliente> obter(@PathVariable("id") Long id) {
        try {
            return this._repositoryCliente.findById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                'Produto não encontrado',
                e
            );
        }
    }

    @PostMapping
    @ResponseStatus (code = HttpStatus.OK)
    public Cliente adicionar(@RequestBody Cliente cliente) {
        try {
            return this._repositoryCliente.save(cliente);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                'Produto não encontrado',
                e
            );
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus (code = HttpStatus.OK)
    public Cliente atualizar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        try {
            cliente.setId(id);
            return this._repositoryCliente.save(cliente);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                'Produto não encontrado',
                e
            );
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (code = HttpStatus.OK)
    public void deletar(@PathVariable("id") Long id) {
        try {
            this._repositoryCliente.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                'Produto não encontrado',
                e
            );
        }
    }
}
