package com.mossonthetree.gid.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.List;

import com.mossonthetree.gid.model.Milestone;

@Repository
public class MilestoneRepository {
	@PersistenceContext
	private EntityManager em;

	public Milestone insert(Milestone value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("insertMilestone");
		q.setParameter("description", value.getDescription());
		q.setParameter("item_id", value.getItemId());
		try {
			q.execute();
			return (Milestone)q.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	public List<Milestone> selectOfItem(int itemId) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectItemMilestones");
		q.setParameter("item_id", itemId);
		List<Milestone> result = (List<Milestone>)q.getResultList();
		return result;
	}

	public boolean delete(int value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("deleteMilestone");
		q.setParameter("milestone_id", value);
		try {
			q.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public Milestone selectByPk(int value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectMilestone");
		q.setParameter("milestone_id", value);
		try {
			Milestone result = (Milestone)q.getSingleResult();
			return result;
		} catch (NoResultException ex) {
			return null;
		}
	}


	public boolean update(Milestone value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("updateMilestone");
		q.setParameter("milestone_id", value.getMilestoneId());
		q.setParameter("description", value.getDescription());
		q.setParameter("item_id", value.getItemId());
		try {
			q.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public List<Milestone> selectAll() {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectAllMilestones");
		List<Milestone> result = (List<Milestone>)q.getResultList();
		return result;
	}

}
