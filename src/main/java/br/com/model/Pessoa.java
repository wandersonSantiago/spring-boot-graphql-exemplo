package br.com.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@GraphQLQuery(name = "id", description = "Id da Pessoa")
	private Long id;
	
	@GraphQLQuery(name = "nome", description = "nome da pessoa")
	@NonNull
	private String nome;
	
	@GraphQLQuery(name = "dataNascimento", description = "Data Nascimento da pessoa")
	private LocalDate dataNascimento;
	
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
	
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Documento> documentos = new ArrayList<Documento>();

	public Pessoa() {
		super();
	}
	
	
	
}
