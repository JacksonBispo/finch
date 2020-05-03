package br.com.finch.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private List<Integer> ingredientes = new ArrayList<Integer>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Integer> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Integer> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
}
