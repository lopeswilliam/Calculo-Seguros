package br.com.cadastro.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.entity.Categoria;
import br.com.cadastro.models.CategoriaRequest;
import br.com.cadastro.models.CategoriaResponse;
import br.com.cadastro.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	private static final Logger logger = LogManager.getLogger(CategoriaService.class);

	/**
	 * @param CategoriaRequest
	 * @return
	 */
	public Categoria inclusaoCategoria(CategoriaRequest prodRequest) throws Exception {

		Categoria categoria = new Categoria();
		categoria = addCategoria(prodRequest, categoria);
		categoria = categoriaRepository.save(categoria);

		return categoria;

	}

	/**
	 * @param depRequest
	 * @param categoria
	 * @return
	 */
	private Categoria addCategoria(CategoriaRequest depRequest,  Categoria  categoria) {

		categoria.setNome(depRequest.getNome());
		categoria.setTipoCategoria(depRequest.getTipoCategoria());
		categoria.setIof(new BigDecimal(depRequest.getIof() ) != null ? new BigDecimal(depRequest.getIof()) : BigDecimal.ZERO );
		categoria.setCofins(new BigDecimal(depRequest.getCofins())  != null ? new BigDecimal(depRequest.getCofins()) : BigDecimal.ZERO );
		categoria.setPis(new BigDecimal(depRequest.getPis())  != null ? new BigDecimal(depRequest.getPis()) : BigDecimal.ZERO );

		return categoria;

	}

	public CategoriaResponse calcularPrecoTarifadoProdutoSeguros(String nome, String categoria, String preco_base) {

		CategoriaResponse resultado = new CategoriaResponse();

		List<Categoria> tarifaProduto = buscarTarifaProduto(categoria);

		BigDecimal precoBase = new BigDecimal(preco_base);

		for (Categoria categ : tarifaProduto) {

			BigDecimal newPrecoIof = BigDecimal.ZERO;
			BigDecimal newPrecoPis = BigDecimal.ZERO;
			BigDecimal newPrecoCofins = BigDecimal.ZERO;
			BigDecimal valorTarifado = BigDecimal.ZERO;

			newPrecoIof = calculoIof(precoBase, categ, newPrecoIof);
			newPrecoPis = calculoPis(precoBase, categ, newPrecoPis);
			newPrecoCofins = calculoCofins(precoBase, categ, newPrecoCofins);

			valorTarifado = calculoValorTarifado(newPrecoIof, newPrecoPis, newPrecoCofins, valorTarifado, precoBase);

			resultado = resultadoCalculoResponse(resultado, precoBase, categ, valorTarifado);
		}

		return resultado;
	}

	private BigDecimal calculoCofins(BigDecimal precoBase, Categoria categ, BigDecimal newPrecoCofins) {
		newPrecoCofins = newPrecoCofins.add(precoBase.multiply(categ.getCofins() ));
		return newPrecoCofins;
	}

	private BigDecimal calculoPis(BigDecimal precoBase, Categoria categ, BigDecimal newPrecoPis) {
		newPrecoPis = newPrecoPis.add( precoBase.multiply(categ.getPis()) );
		return newPrecoPis;
	}

	private BigDecimal calculoIof(BigDecimal precoBase, Categoria categ, BigDecimal newPrecoIof) {
		newPrecoIof = newPrecoIof.add( precoBase.multiply(categ.getIof())  );
		return newPrecoIof;
	}

	private CategoriaResponse resultadoCalculoResponse(CategoriaResponse resultado, BigDecimal precoBase, Categoria categ,BigDecimal valorTarifado) {
		resultado.setId(UUID.randomUUID().toString());
		resultado.setNome(categ.getNome() );
		resultado.setTipoCategoria(categ.getTipoCategoria());
		resultado.setPrecoBase(precoBase);
		resultado.setPrecoTarifado(valorTarifado.setScale(2));

		return resultado;
	}

	private BigDecimal calculoValorTarifado(BigDecimal newPrecoIof, BigDecimal newPrecoPis, BigDecimal newPrecoCofins,BigDecimal valorTarifado, BigDecimal precoBase ) {
		valorTarifado = valorTarifado.add(newPrecoIof).add(newPrecoPis).add(newPrecoCofins).divide(new BigDecimal(100));
		valorTarifado = precoBase.add(valorTarifado);
		return valorTarifado;
	}


	public List<Categoria> buscarTarifaProduto(String categoria) {

		List<Categoria> tarifaProduto = new ArrayList<Categoria>();

		if(categoria == null && categoria.equals("")) {
			logger.info("Categoria deve ser informado");
		}
		
		try {
			
			tarifaProduto = categoriaRepository.findByTipoCategoria(categoria.toUpperCase());
			
		} catch (Exception e) {
			logger.error("Ocorreu um erro ao consultar o tipo de categoria", e.getMessage());
		}

		return tarifaProduto;

	}


}
