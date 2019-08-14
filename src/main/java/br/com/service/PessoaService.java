package br.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Pessoa;
import br.com.repository.PessoaRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class PessoaService {

	@Autowired
    private PessoaRepository repository;

    @GraphQLQuery(name = "pessoas")
    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    @GraphQLQuery(name = "pessoa") 
    public Optional<Pessoa> findById(@GraphQLArgument(name = "id") Long id) {
    	Optional<Pessoa>  pessoa = repository.findById(id);
        return pessoa;
    }

    @GraphQLMutation(name = "insertPessoa")
    public Pessoa insertPessoa(@GraphQLArgument(name = "pessoa") Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @GraphQLMutation(name = "deletePessoa")
    public void deletePessoa(@GraphQLArgument(name = "id") Long id) {
    	repository.deleteById(id);
    }   
}
