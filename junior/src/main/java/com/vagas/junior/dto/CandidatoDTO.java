package com.vagas.junior.dto;

import java.io.Serializable;
import java.util.Objects;

import com.vagas.junior.entity.CandidatoEntity;

public class CandidatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Long idade;

	public CandidatoDTO() {
		super();
	}

	public CandidatoDTO(Long id, String nome, Long idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatoDTO other = (CandidatoDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(idade, other.idade) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "CandidatoDTO [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}
	
	public CandidatoEntity toEntity(CandidatoDTO dto) {
		CandidatoEntity entity = new CandidatoEntity();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setIdade(dto.getIdade());
		return entity;
	}

}
