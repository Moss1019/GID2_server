package com.mossonthetree.gid.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.List;

import com.mossonthetree.gid.model.Item;

@Repository
public class ItemRepository {
	@PersistenceContext
	private EntityManager em;

	public Item insert(Item value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("insertItem");
		q.setParameter("title", value.getTitle());
		q.setParameter("user_id", value.getUserId());
		try {
			q.execute();
			return (Item)q.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	public List<Item> selectOfUser(int userId) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectUserItems");
		q.setParameter("user_id", userId);
		List<Item> result = (List<Item>)q.getResultList();
		return result;
	}

	public boolean delete(int value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("deleteItem");
		q.setParameter("item_id", value);
		try {
			q.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public Item selectByPk(int value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectItem");
		q.setParameter("item_id", value);
		try {
			Item result = (Item)q.getSingleResult();
			return result;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Item selectByTitle(String value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectItemsByTitle");
		q.setParameter("title", value);
		try {
			Item result = (Item)q.getSingleResult();
			return result;
		} catch (NoResultException ex) {
			return null;
		}
	}


	public boolean update(Item value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("updateItem");
		q.setParameter("item_id", value.getItemId());
		q.setParameter("title", value.getTitle());
		q.setParameter("user_id", value.getUserId());
		try {
			q.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public List<Item> selectAll() {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectAllItems");
		List<Item> result = (List<Item>)q.getResultList();
		return result;
	}

}
