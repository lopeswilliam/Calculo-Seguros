package br.com.cadastro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.entity.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	List<Categoria> findById(String id);
	
	List<Categoria> findByTipoCategoria(String tipoCategoria);

}
