package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Movimentacao;
import br.com.repository.MovimentacaoRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class MovimentacaoService {

	@Autowired
    private MovimentacaoRepository repository;

    @GraphQLQuery(name = "movimentacoes")
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    @GraphQLQuery(name = "movimentacao")
    public List<Movimentacao> findByPessoaId(@GraphQLArgument(name = "idPessoa") Long idPessoa) {
    	List<Movimentacao>  movimentacao = repository.findByPessoaId(idPessoa);
        return movimentacao;
    }

    @GraphQLMutation(name = "insertMovimentacao")
    public Movimentacao insertMovimentacao(@GraphQLArgument(name = "movimentacao") Movimentacao movimentacao) {
        return repository.save(movimentacao);
    }

    @GraphQLMutation(name = "deleteMovimentacao")
    public void deleteMovimentacao(@GraphQLArgument(name = "id") Long id) {
    	repository.deleteById(id);
    }   
}
