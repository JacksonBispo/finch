package br.com.finch.domain;

import java.io.Serializable;

public class Adicional implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private Ingrediente ingrediente;
	private Integer qtde;
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	
	

}
