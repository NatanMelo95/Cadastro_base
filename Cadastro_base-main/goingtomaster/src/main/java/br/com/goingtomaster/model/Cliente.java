package br.com.goingtomaster.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Cliente {

	private Long Id;
	private String nome;
	private Integer idade;
	private String sexo;
	private String estadoCivil;
	private String profissao;
	private Integer cpfOuCnpj;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public Integer getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(Integer cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	
}