package br.com.finch.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.finch.domain.Produto;
import br.com.finch.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?>findOne(@PathVariable Integer id){
		try {
			Produto obj = service.findOne(id);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping(value="/montagem",method = RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Produto obj){
		Produto newObj = service.insertProduto(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("{/id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
