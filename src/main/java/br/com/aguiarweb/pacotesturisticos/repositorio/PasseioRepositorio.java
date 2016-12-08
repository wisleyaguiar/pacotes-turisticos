package br.com.aguiarweb.pacotesturisticos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aguiarweb.pacotesturisticos.dominio.Passeio;

@Repository
public interface PasseioRepositorio extends JpaRepository<Passeio, Integer> {

}
