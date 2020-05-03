package br.com.finch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.finch.domain.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

}
