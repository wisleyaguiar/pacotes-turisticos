package br.com.aguiarweb.pacotesturisticos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aguiarweb.pacotesturisticos.dominio.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>, ClienteRepositorioCustom {

}