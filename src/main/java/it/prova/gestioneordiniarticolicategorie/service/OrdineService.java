package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public interface OrdineService {

	//per injection
	public void setOrdineDAO (OrdineDAO ordineDAO);
	
	public void setArticoloDAO (ArticoloDAO articoloDAO);
	
	
	public List<Ordine> listAll() throws Exception;
	
	public Ordine caricaSingoloElemento (Long id) throws Exception;
	
	public void aggiorna (Ordine ordineInstance) throws Exception;

	public void inserisciNuovo (Ordine ordineInstance) throws Exception;
	
	public void rimuovi (Long idOrdine) throws Exception;
	
	public List<Ordine> listaOrdiniPerCategoria (Long idCategoria) throws Exception;
	
	public Ordine ordinePiuRecentePerCategoria (Long idCategoria) throws Exception;
	
}
