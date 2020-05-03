package br.com.finch.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.finch.domain.Ingrediente;
import br.com.finch.repository.IngredienteRepository;
@Service
public class IngredienteService {
	@Autowired
	private IngredienteRepository repository;
	
	public Ingrediente findOne(Integer id) {
		Optional<Ingrediente> obj = repository.findById(id);	
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:"+ id+ ", Tipo: "+ Ingrediente.class.getName(), null));
	}
}
