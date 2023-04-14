package it.prova.gestioneordiniarticolicategorie.dao;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.model.Articolo;

public interface ArticoloDAO extends IBaseDAO<Articolo>{

	public Articolo caricaArticoloEager (Long idArticolo) throws Exception;
	
	public void deleteCompletoArticolo (Long idArticolo) throws Exception;
	
	public List<Articolo> findAllByOrdine (Long idOrdine) throws Exception;
	
	public Double sumPrezzoArticoliDiUnaCategoria (Long idCategoria) throws Exception;
} 
