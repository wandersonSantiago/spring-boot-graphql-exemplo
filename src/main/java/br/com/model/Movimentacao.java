package br.com.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;

@Entity
@Data
public class Movimentacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@GraphQLQuery(name = "id", description = "ID da Movimentacao")
	private Long id;
	
	@GraphQLQuery(name = "dataEHora", description = "Data e Hora da Movimentacao")
	private LocalDate dataEHora;
		
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	@GraphQLQuery(name = "idPessoa", description = "ID da Pessoa na Movimentacao")
	private Pessoa pessoa;
	
	public Movimentacao() {
		
	}
}
