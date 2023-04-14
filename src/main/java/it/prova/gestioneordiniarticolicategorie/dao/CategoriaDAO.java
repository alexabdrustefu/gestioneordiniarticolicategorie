package it.prova.gestioneordiniarticolicategorie.dao;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria>{
	
	public Categoria caricaCategoriaEager (Long idCategoria) throws Exception;

	public void deleteCompletaCAtegoria (Long idCategoria) throws Exception;
	
	public List<Categoria> findDistinctByOrdine (Long idOrdine) throws Exception;
}
