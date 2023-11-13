package br.com.cadastro.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class CategoriaResponse implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3419050424334683974L;
	private String id;
	private String nome;
	private String tipoCategoria;
	private BigDecimal precoBase;
	private BigDecimal precoTarifado;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoCategoria() {
		return tipoCategoria;
	}
	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}
	public BigDecimal getPrecoBase() {
		return precoBase;
	}
	public void setPrecoBase(BigDecimal precoBase) {
		this.precoBase = precoBase;
	}
	public BigDecimal getPrecoTarifado() {
		return precoTarifado;
	}
	public void setPrecoTarifado(BigDecimal precoTarifado) {
		this.precoTarifado = precoTarifado;
	}

}
