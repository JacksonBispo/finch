package br.com.finch.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Date data; 
	
	private Produto produto;
	
	private List<Adicional> adicional = new ArrayList<Adicional>();

	public List<Adicional> getAdicional() {
		return adicional;
	}

	public void setAdicional(List<Adicional> adicional) {
		this.adicional = adicional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido(Integer id, Date data, Produto produto) {
		super();
		this.id = id;
		this.data = data;
		this.produto = produto;
	}
	
	
}
