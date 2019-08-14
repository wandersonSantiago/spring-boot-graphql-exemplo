package br.com;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.enuns.TipoDocumentoEnum;
import br.com.model.Documento;
import br.com.model.Movimentacao;
import br.com.model.Pessoa;
import br.com.repository.DocumentoRepository;
import br.com.repository.MovimentacaoRepository;
import br.com.repository.PessoaRepository;

@SpringBootApplication
public class SpringBootGraphqlExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlExemploApplication.class, args);
	}

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private DocumentoRepository documentoRepository;
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Bean
	ApplicationRunner init() {

		return args -> {
			Stream.of("Jose", "Maria", "Arnaldo", "GalvÃ£o", "Leandro", "Aline", "Alice", "Magali", "Juraci")
					.forEach(nome -> {
						Pessoa pessoa = new Pessoa();
						pessoa.setNome(nome);
						pessoa.setDataNascimento(LocalDate.of(1991, 05, 20));

						pessoaRepository.save(pessoa);

						for (TipoDocumentoEnum tipo : TipoDocumentoEnum.values()) {
							Documento doc = new Documento();
							doc.setNumero(UUID.randomUUID().toString());
							doc.setTipo(tipo);
							doc.setPessoa(pessoa);
							documentoRepository.save(doc);
						}
						int count = 0;
						while (count < 9) {
							Movimentacao mov = new Movimentacao();
							mov.setDataEHora(LocalDate.now());
							mov.setPessoa(pessoa);
							movimentacaoRepository.save(mov);
							count++;
						}

					});
		};
	}

}
