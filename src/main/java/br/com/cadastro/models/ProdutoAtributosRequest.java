package br.com.cadastro.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoAtributosRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7825990603358933459L;

	private String nome;
	
	private String categoria;
		
	private BigDecimal precoBase;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(BigDecimal precoBase) {
		this.precoBase = precoBase;
	}


}
