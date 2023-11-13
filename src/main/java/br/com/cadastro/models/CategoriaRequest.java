package br.com.cadastro.models;

import java.io.Serializable;

public class CategoriaRequest implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3419050424334683974L;
	private Long id;
	private String nome;
	private String tipoCategoria;
	private String iof;
	private String pis;
	private String cofins;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIof() {
		return iof;
	}
	public void setIof(String iof) {
		this.iof = iof;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public String getCofins() {
		return cofins;
	}
	public void setCofins(String cofins) {
		this.cofins = cofins;
	}
	public String getTipoCategoria() {
		return tipoCategoria;
	}
	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

}
