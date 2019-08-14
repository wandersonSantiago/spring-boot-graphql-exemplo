package br.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.enuns.TipoDocumentoEnum;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Documento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@GraphQLQuery(name = "id", description = "ID da Documento")
	private Long id;
	
	@GraphQLQuery(name = "numero", description = "Numero do documento")
	private String numero;
		
	@GraphQLQuery(name = "tipo", description = "Tipo do documento")
	@Enumerated(EnumType.ORDINAL)
	private TipoDocumentoEnum tipo;
	
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	@GraphQLQuery(name = "idPessoa", description = "ID da Pessoa no Documento")
	private Pessoa pessoa;
	
	
	
}
