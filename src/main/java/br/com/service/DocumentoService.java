package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Documento;
import br.com.repository.DocumentoRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class DocumentoService {

	@Autowired
    private DocumentoRepository repository;

    @GraphQLQuery(name = "documentos")
    public List<Documento> findAll() {
        return repository.findAll();
    }

    @GraphQLQuery(name = "documento")
    public List<Documento> findByPessoaId(@GraphQLArgument(name = "idPessoa") Long idPessoa) {
    	List<Documento>  documento = repository.findByPessoaId(idPessoa);
        return documento;
    }

    @GraphQLMutation(name = "insertDocumento")
    public Documento insertDocumento(@GraphQLArgument(name = "documento") Documento documento) {
        return repository.save(documento);
    }

    @GraphQLMutation(name = "deleteDocumento")
    public void deleteDocumento(@GraphQLArgument(name = "id") Long id) {
    	repository.deleteById(id);
    }   
}
