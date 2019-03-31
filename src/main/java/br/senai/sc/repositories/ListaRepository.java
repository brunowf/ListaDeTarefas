package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer>{

}
