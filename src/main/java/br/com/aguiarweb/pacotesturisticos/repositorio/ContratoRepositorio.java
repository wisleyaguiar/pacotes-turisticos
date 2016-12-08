package br.com.aguiarweb.pacotesturisticos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aguiarweb.pacotesturisticos.dominio.Contrato;

@Repository
public interface ContratoRepositorio extends JpaRepository<Contrato, Integer> {

}
