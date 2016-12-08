package br.com.aguiarweb.pacotesturisticos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aguiarweb.pacotesturisticos.dominio.Pacote;

@Repository
public interface PacoteRepositorio extends JpaRepository<Pacote, Integer> {

}
