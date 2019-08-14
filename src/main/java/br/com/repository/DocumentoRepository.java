package br.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	List<Documento> findByPessoaId(Long id);
}