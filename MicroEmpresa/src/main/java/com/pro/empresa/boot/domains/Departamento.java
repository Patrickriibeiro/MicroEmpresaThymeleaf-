package com.pro.empresa.boot.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long>{
	// Unique, significa que a coluna vai ser unica
	// Length pode ter somente 60 caractéries
	@NotBlank(message = "Informe um nome.")
	@Size(min = 3, max = 60 , message = "O nome departamento deve ter entre {min} e {max} caracteres")	
	@Column(name = "nome", nullable = false, unique = true , length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "departamento") // relacionamento Bidirecional
	private List<Cargo> cargos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
