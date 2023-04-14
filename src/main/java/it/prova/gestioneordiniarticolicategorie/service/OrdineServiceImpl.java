package it.prova.gestioneordiniarticolicategorie.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordiniarticolicategorie.dao.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.exception.OrdineConArticoliException;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

public class OrdineServiceImpl implements OrdineService {

	private OrdineDAO ordineDAO;
	private ArticoloDAO articoloDAO;

	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;
	}
	
	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
	}

	@Override
	public List<Ordine> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// injection
			ordineDAO.setEntityManager(entityManager);

			return ordineDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Ordine caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// injection
			ordineDAO.setEntityManager(entityManager);

			return ordineDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			entityManager.getTransaction().begin();

			// injection
			ordineDAO.setEntityManager(entityManager);

			ordineDAO.update(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			entityManager.getTransaction().begin();

			// injection
			ordineDAO.setEntityManager(entityManager);

			ordineDAO.insert(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Long idOrdine) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			entityManager.getTransaction().begin();

			// injection
			ordineDAO.setEntityManager(entityManager);
			articoloDAO.setEntityManager(entityManager);
			
			if(articoloDAO.findAllByOrdine(idOrdine).size()>0) {
				throw new OrdineConArticoliException("Impossibile rimuovere ordine con articoli associati");
			}

			ordineDAO.delete(ordineDAO.get(idOrdine));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public List<Ordine> listaOrdiniPerCategoria(Long idCategoria) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// injection
			ordineDAO.setEntityManager(entityManager);

			return ordineDAO.findAllByCategoria(idCategoria);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Ordine ordinePiuRecentePerCategoria(Long idCategoria) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// injection
			ordineDAO.setEntityManager(entityManager);

			return ordineDAO.getRecentOrdineByCategoria(idCategoria);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}



}
