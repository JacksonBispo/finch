package br.com.finch.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.finch.domain.Ingrediente;
import br.com.finch.domain.Produto;
import br.com.finch.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private IngredienteService service;
	
	
	public Produto findOne(Integer id) {
		Optional<Produto> obj = repository.findById(id);	
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:"+ id+ ", Tipo: "+ Produto.class.getName(), null));
	}
	
	public Produto insertProduto(Produto obj) {
		Produto newObj = new Produto();
		newObj.setNome(obj.getNome());
		newObj.getIngredientes()
				.addAll(obj.getIngredientes().stream().map(x->{
					Ingrediente ing = service.findOne(x.getId());
					ing.getProdutos().add(newObj);
					return ing;
				}).collect(Collectors.toList()));
		 newObj.setPreco(newObj.getPrecoTotal());
		 repository.save(newObj);
		return newObj;
		}
	
	
}
