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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.goingtomaster.model.Cliente;
import br.com.goingtomaster.repository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")

public class ClienteController {
    @Autowired
    private ClienteRepository _repositoryCliente;

    @GetMapping
    @ResponseStatus (code = HttpStatus.PARTIAL_CONTENT)
    public List<Cliente> obter() {
        return this._repositoryCliente.findAll();
    }

    @GetMapping("/{id}")
	public ResponseEntity<Cliente> obter(@PathVariable("id") long id) {
	    Optional<Cliente> obterCliente = _repositoryCliente.findById(id);

	    if (obterCliente.isPresent()) {
	      return new ResponseEntity<>(obterCliente.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
        
    @PostMapping
    @ResponseStatus (code = HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente) {
    	return this._repositoryCliente.save(cliente);
    }

    @PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable(value = "id") long id, @RequestBody Cliente cliente) {
	    try {
	    	cliente.setId(id);
	    	var clienteAtualizado = _repositoryCliente.save(cliente);
	    	return new ResponseEntity<>(clienteAtualizado, HttpStatus.NO_CONTENT);
	    } catch (Exception e){
	    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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
                "Cliente não encontrado",
                e
            );
        }
    }
}
