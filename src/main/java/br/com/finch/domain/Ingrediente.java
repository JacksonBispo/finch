package br.com.finch.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingrediente implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Double preco;
	
	@ManyToMany
	@JoinTable(name = "PRODUTO_INGREDIENTE",
	joinColumns = @JoinColumn(name="ingrediente_id"),
	inverseJoinColumns =@JoinColumn(name="produto_id"))
	@JsonIgnore
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Ingrediente() {
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Ingrediente(Integer id, String descricao, Double preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", produtos=" + produtos
				+ "]";
	}
	
	
}
