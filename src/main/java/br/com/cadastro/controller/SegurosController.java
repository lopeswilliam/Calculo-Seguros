package br.com.cadastro.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.entity.Categoria;
import br.com.cadastro.models.CategoriaRequest;
import br.com.cadastro.models.CategoriaResponse;
import br.com.cadastro.services.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin
@Api(value = "Categoria")
@RequestMapping("/categoria/v1")
public class SegurosController {

	@Autowired
	private CategoriaService categoriaService;	
	
	private static final Logger logger = LogManager.getLogger(SegurosController.class);
	
	@ApiOperation(value = "Inclui Categoria")
	@PostMapping(path = "/incluirCategoria" , produces = {"application/json"})
	public ResponseEntity<Categoria> inclusaoCategoria(@RequestBody CategoriaRequest categoriaRequest) throws Exception {
		logger.info("Iniciando a Inclusao do categoriaService");
		Categoria inclusaoCategoria = categoriaService.inclusaoCategoria(categoriaRequest );
		return new ResponseEntity<>(HttpStatus.OK).ok(inclusaoCategoria);
	}
	
	@ApiOperation(value = "Calcular Categoria")
	@GetMapping(path = "/calcular" , produces = {"application/json"})
	public CategoriaResponse calcularPrecoTarifadoProdutoSeguros(@RequestParam("nome") String nome, 
			@RequestParam("categoria") String categoria,
			@RequestParam("preco_base") String preco_base ) {
		logger.info("Iniciando a consulta do categoriaService");
		return categoriaService.calcularPrecoTarifadoProdutoSeguros(nome, categoria, preco_base);
	}

}
