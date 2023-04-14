package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import it.prova.gestioneordiniarticolicategorie.dao.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

public interface ArticoloService {

	//per injection
	public void setArticoloDAO (ArticoloDAO articoloDAO);
	
	
	public List<Articolo> listAll() throws Exception;
	
	public Articolo caricaSingoloElemento(Long id) throws Exception;
	
	public void aggiorna (Articolo articoloInstance) throws Exception;
	
	public void inserisciNuovo (Articolo articoloInstance) throws Exception;
	
	public void rimuovi (Long idArticolo) throws Exception;
	
	public void aggiungiCategoria (Articolo articoloInstance, Categoria categoriaInstance) throws Exception;
	
	public Articolo caricaArticoloEager (Long idArticolo) throws Exception;
	
	public void rimozioneArticoloCompleta (Long idArticolo) throws Exception;
	
	public Double sommaPrezzoArticoliDiUnaCategoria (Long idCategoria) throws Exception;
}
