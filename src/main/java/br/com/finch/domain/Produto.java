package br.com.finch.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	@ManyToMany(mappedBy = "produtos")
	private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

	 public Produto() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public Produto(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;

	}
	public Double getPrecoTotal() {
		double soma = 0.0;
		for(Ingrediente ing : ingredientes) {
			setPreco(soma += ing.getPreco());
		}
		return preco;
	}
	

	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + getPrecoTotal() + ", ingredientes=" + ingredientes + "]";
	}
	
}
