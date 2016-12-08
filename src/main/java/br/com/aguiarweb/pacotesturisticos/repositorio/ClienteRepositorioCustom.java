package br.com.aguiarweb.pacotesturisticos.repositorio;

import java.util.List;

import br.com.aguiarweb.pacotesturisticos.dominio.Cliente;

public interface ClienteRepositorioCustom {

	public Cliente buscarNomeExato(String nome);
	public List<Cliente> buscarTodosOrdenadosPorNome();
	public List<Cliente> buscarPorNome(String trecho);
	
}
