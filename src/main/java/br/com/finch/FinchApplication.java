package br.com.finch;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.finch.domain.Ingrediente;
import br.com.finch.domain.Produto;
import br.com.finch.repository.IngredienteRepository;
import br.com.finch.repository.ProdutoRepository;

@SpringBootApplication
public class FinchApplication implements CommandLineRunner{
	/*
	 * Alface: R$ 0.40
	●	 Bacon: R$ 2,00
	●    Hambúrguer: R$ 3,00
	● 	 Ovo: R$ 0,80
	● 	 Queijo: R$ 1,50
	 * 
	 */
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	public static void main(String[] args) {
		SpringApplication.run(FinchApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Ingrediente ing = new Ingrediente(null, "Alface", 0.40);
		Ingrediente ing2 = new Ingrediente(null, "Bacon", 2.00);
		Ingrediente ing3 = new Ingrediente(null, "Hambúrguer", 3.00);
		Ingrediente ing4 = new Ingrediente(null, "ovo", 0.80);
		Ingrediente ing5 = new Ingrediente(null, "queijo", 1.50);
		Ingrediente ing6 = new Ingrediente(null, "Hambúrguer de carne e queijo", 4.50);
		
		Produto p = new Produto(null, "X-bacon");
		Produto p2 = new Produto(null, "X-burguer");
		Produto p3 = new Produto(null, "X-egg");
		Produto p4 = new Produto(null, "X-egg-bacon");
		Produto p5 = new Produto(1, "X-salada");
		p.getIngredientes().addAll(Arrays.asList(ing,ing2));
		p.setPreco(p.getPrecoTotal());
		
		p2.getIngredientes().addAll(Arrays.asList(ing6));
		p2.setPreco(p2.getPrecoTotal());		
		p3.getIngredientes().addAll(Arrays.asList(ing4,ing6));
		p3.setPreco(p3.getPrecoTotal());
		p4.getIngredientes().addAll(Arrays.asList(ing2,ing4,ing6));
		p4.setPreco(p4.getPrecoTotal());
		p5.getIngredientes().addAll(Arrays.asList(ing,ing3));
		ing2.getProdutos().addAll(Arrays.asList(p,p4));
		ing4.getProdutos().addAll(Arrays.asList(p3,p4));
		ing6.getProdutos().addAll(Arrays.asList(p,p2,p3,p4));
		
		produtoRepository.saveAll(Arrays.asList(p,p2,p3,p4));
		ingredienteRepository.saveAll(Arrays.asList(ing,ing2,ing3,ing4,ing5, ing6));
	}

}
