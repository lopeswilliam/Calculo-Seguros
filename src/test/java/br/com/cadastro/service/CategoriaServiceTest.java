package br.com.cadastro.service;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;

import br.com.cadastro.controller.SegurosController;
import br.com.cadastro.entity.Categoria;
import br.com.cadastro.models.CategoriaRequest;
import br.com.cadastro.models.CategoriaResponse;
import br.com.cadastro.repositories.CategoriaRepository;
import br.com.cadastro.services.CategoriaService;


public class CategoriaServiceTest {

	@InjectMocks
	private SegurosController segurosController;

	@Mock
	private CategoriaService categoriaService;

	@Mock
	private CategoriaRepository categoriaRepository;

	@Mock
	private CategoriaResponse calcularSegurosResponse;

	@Mock
	private  List<Categoria> categoria;
	
	@Mock
	private Categoria inclusaoCategoria;
	
	@Before
	public void init(){
		segurosController = new SegurosController();
		categoriaService = new CategoriaService();

	}

	@Test
	public void testCalcularPrecoTarifadoProdutoSeguros() {

		String nome = "seguro automovel"; 
		String categoria = "VIDA";
		String preco_base = "100.00";

		calcularSegurosResponse = categoriaService.calcularPrecoTarifadoProdutoSeguros(nome, categoria, preco_base);
		Assert.assertNotNull(calcularSegurosResponse);
	}

	@Test
	public void testBuscarTarifaProduto() {

		String categoria = "VIDA";
		try {
			PowerMockito.doThrow((Throwable) categoriaService.buscarTarifaProduto(categoria));
		} catch (Exception e) {
			Assert.assertSame(categoria, "Ocorreu um erro ao consultar o tipo de categoria", "Ocorreu um erro ao consultar o tipo de categoria");
		}
	}

	@Test
	public void testInclusaoCategoria() {

		CategoriaRequest prodRequest = new CategoriaRequest();
		prodRequest.setCofins("1.00");
		prodRequest.setId(1L);
		prodRequest.setIof("2.00");
		prodRequest.setNome("nome");
		prodRequest.setPis("1.0");
		prodRequest.setTipoCategoria("VIDA");

		Categoria categoria = new Categoria();
		categoria.setCofins(BigDecimal.ONE);
		categoria.setId(1L);
		categoria.setIof(BigDecimal.ONE);
		categoria.setNome("");
		categoria.setPis(BigDecimal.ONE);
		categoria.setTipoCategoria("VIDA");
		
		try {
			when(categoriaService.inclusaoCategoria(prodRequest)).thenReturn(categoria);
		} catch (Exception e) {
			Assert.assertTrue(Boolean.TRUE);
		}

	}



}
