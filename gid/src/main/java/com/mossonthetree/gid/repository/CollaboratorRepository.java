package com.mossonthetree.gid.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.List;

import com.mossonthetree.gid.model.User;
import com.mossonthetree.gid.model.Collaborator;

@Repository
public class CollaboratorRepository {
	@PersistenceContext
	private EntityManager em;

	public Collaborator insert(Collaborator value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("insertCollaborator");
		q.setParameter("user_id", value.getUserId());
		q.setParameter("item_id", value.getItemId());
		try {
			q.execute();
			return (Collaborator)q.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	public List<User> selectItemCollaborators(int itemId) { 
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectItemCollaborators");
		q.setParameter("item_id", itemId);
		List<User> result = (List<User>)q.getResultList();
		return result;
	}

	public boolean delete(int userId, int itemId) { 
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("deleteCollaborator");
		q.setParameter("user_id", userId);
		q.setParameter("item_id", itemId);
		try {
			q.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
