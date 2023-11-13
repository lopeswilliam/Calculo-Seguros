package br.com.cadastro.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6249733210874767507L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String tipoCategoria;
	
	@Column(nullable = false)
	private BigDecimal iof;
		
	@Column(nullable = false)
	private BigDecimal pis;
	
	@Column(nullable = false)
	private BigDecimal cofins;

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

	public String getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public BigDecimal getIof() {
		return iof;
	}

	public void setIof(BigDecimal iof) {
		this.iof = iof;
	}

	public BigDecimal getPis() {
		return pis;
	}

	public void setPis(BigDecimal pis) {
		this.pis = pis;
	}

	public BigDecimal getCofins() {
		return cofins;
	}

	public void setCofins(BigDecimal cofins) {
		this.cofins = cofins;
	}


	
	
	
}
