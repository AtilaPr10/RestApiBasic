package com.example.demo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Tarefa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	@NotNull(message = "Titulo não pode ser nulo!")
    @Size(message="O campo descrição deve possuir no minimo 5 e no maximo 80 carcateres",min = 5 ,max= 80)
	@NotEmpty(message="O campo descrição nao pode ser vazio!")
	private String descricao;
	
	@Column
	private BigDecimal preco_custo;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco_custo() {
		return preco_custo;
	}

	public void setPreco_custo(BigDecimal preco_custo) {
		this.preco_custo = preco_custo;
	}
	
	
	
	
	
	
	

}
