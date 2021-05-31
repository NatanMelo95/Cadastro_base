package br.com.goingtomaster;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Produto {
	
	private Long id;
	private String nome;
	private Integer quantidade;
	private Double valor;
	private String observacao;
	
	public Produto(Long id, String nome, Integer quantidade, Double valor, String observacao) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.observacao = observacao;		
	}

	public Produto(String nome, Integer quantidade, Double valor, String observacao) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}





	
	
