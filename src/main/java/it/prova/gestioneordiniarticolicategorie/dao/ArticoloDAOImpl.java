package it.prova.gestioneordiniarticolicategorie.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import javax.persistence.Query;

import it.prova.gestioneordiniarticolicategorie.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void deleteCompletoArticolo(Long idArticolo) throws Exception {
		entityManager.createNativeQuery("delete from articolo_categoria a where a.articolo_id = ?1").setParameter(1, idArticolo).executeUpdate();
		entityManager.createNativeQuery("delete from articolo a where a.id = ?1").setParameter(1, idArticolo).executeUpdate();
			
	}

	@Override
	public Articolo caricaArticoloEager(Long idArticolo) throws Exception {
		TypedQuery<Articolo> query = entityManager.createQuery("from Articolo a join fetch a.categorie c where a.id = ?1", Articolo.class);
		query.setParameter(1, idArticolo);
		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public List<Articolo> findAllByOrdine(Long idOrdine) throws Exception {
		TypedQuery<Articolo> query = entityManager.createQuery("from Articolo where ordine_id = ?1", Articolo.class);
		query.setParameter(1, idOrdine);
		return query.getResultList();
	}

	@Override
	public Double sumPrezzoArticoliDiUnaCategoria(Long idCategoria) throws Exception {
		Double result = null;
		Query query = entityManager.createQuery("select sum(a.prezzoSingolo) from Articolo a join a.categorie c where c.id = ?1").setParameter(1, idCategoria);
		result = (Double) query.getSingleResult();
		return result;
	}
	

}
