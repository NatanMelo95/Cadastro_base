
package br.com.goingtomaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.goingtomaster.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Optional<Produto> findById (Long id);

}