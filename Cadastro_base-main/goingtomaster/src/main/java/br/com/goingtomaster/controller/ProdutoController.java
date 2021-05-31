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

import br.com.goingtomaster.model.Produto;
import br.com.goingtomaster.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produto")

public class ProdutoController {
    @Autowired
    private ProdutoRepository _repositoryProduto;

    @GetMapping
    @ResponseStatus (code = HttpStatus.PARTIAL_CONTENT)
    public List<Produto> obter() {
        try {
            return this._repositoryProduto.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Produto não encontrado",
                e
            );
        }
    }

    @GetMapping("/{id}")
	public ResponseEntity<Produto> obter(@PathVariable("id") long id) {
	    Optional<Produto> obterProduto = _repositoryProduto.findById(id);

	    if (obterProduto.isPresent()) {
	      return new ResponseEntity<>(obterProduto.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
        
    @PostMapping
    @ResponseStatus (code = HttpStatus.CREATED)
    public Produto adicionar(@RequestBody Produto produto) {
    	return this._repositoryProduto.save(produto);
    }

    @PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable(value = "id") long id, @RequestBody Produto produto) {
	    try {
	    	produto.setId(id);
	    	var produtoAtualizado = _repositoryProduto.save(produto);
	    	return new ResponseEntity<>(produtoAtualizado, HttpStatus.NO_CONTENT);
	    } catch (Exception e){
	    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    }
	}

    @DeleteMapping("/{id}")
    @ResponseStatus (code = HttpStatus.OK)
    public void deletar(@PathVariable("id") Long id) {
        try {
            this._repositoryProduto.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Produto não encontrado",
                e
            );
        }
    }
}
