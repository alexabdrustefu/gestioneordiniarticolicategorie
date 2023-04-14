package it.prova.gestioneordiniarticolicategorie.dao;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine>{
	
	public Ordine getEagerArticoli (Long idOrdine) throws Exception;
	
	public List<Ordine> findAllByCategoria (Long idCategoria) throws Exception;
	
	public Ordine getRecentOrdineByCategoria (Long idCategoria) throws Exception;
}
