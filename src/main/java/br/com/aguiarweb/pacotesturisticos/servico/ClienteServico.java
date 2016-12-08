package br.com.aguiarweb.pacotesturisticos.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aguiarweb.pacotesturisticos.dominio.Cliente;
import br.com.aguiarweb.pacotesturisticos.repositorio.ClienteRepositorio;
import br.com.aguiarweb.pacotesturisticos.servico.excecoes.NaoEncontradoException;
import br.com.aguiarweb.pacotesturisticos.servico.excecoes.ServicoException;
import br.com.aguiarweb.pacotesturisticos.servico.excecoes.ValidacaoException;

@Service
public class ClienteServico {
	
	@Autowired
	private ClienteRepositorio repo;

	public void validar(Cliente x) {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome()==null) {
			erros.add("Favor preencher o campo nome");
		}
		if (x.getEmail()==null) {
			erros.add("Favor preencher o campo email");
		}
		if (x.getTelefone()==null) {
			erros.add("Favor preencher o campo telefone");
		}
		if (x.getCpf()==null) {
			erros.add("Favor preencher o campo CPF");
		}
		if (x.getNascimento()==null) {
			erros.add("Favor preencher um valor válido para a data de nascimento");
		}
		if (x.getRendaMensal()==null) {
			erros.add("Favor preencher um valor válido para a Renda Mensal");
		}
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	public Cliente inserir(Cliente x) throws ServicoException {
		Cliente aux = repo.buscarNomeExato(x.getNome());
		if (aux != null) {
			throw new ServicoException("Já existe um cliente com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public Cliente atualizar(Cliente x) throws ServicoException {
		Cliente aux = repo.findOne(x.getCodCliente());
		if (aux == null) {
			throw new NaoEncontradoException("Cliente não encontrado!", 1);
		}
		aux = repo.buscarNomeExato(x.getNome());
		if (aux != null && aux.getCodCliente()!=x.getCodCliente()) {
			throw new ServicoException("Já existe um outro cliente com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public void excluir(int cod) throws ServicoException {
		Cliente cli = repo.findOne(cod);
		if (cli == null) {
			throw new NaoEncontradoException("Cliente não encontrado!", 1);
		}
		if (!cli.getContratos().isEmpty()) {
			throw new ServicoException("Exclusão não permitida: este cliente possui contratos!", 2);
		}
		repo.delete(cli);
	}
	
	public Cliente buscar(int cod) {
		Cliente cli = repo.findOne(cod);
		if (cli == null) {
			throw new NaoEncontradoException("Cliente não encontrado!", 1);
		}
		return cli;
	}
	
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		return repo.buscarTodosOrdenadosPorNome();
	}
	
	public List<Cliente> buscarPorNome(String trecho) {
		return repo.buscarPorNome(trecho);
	}
	
}
