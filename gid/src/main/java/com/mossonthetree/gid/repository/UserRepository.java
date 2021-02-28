package com.mossonthetree.gid.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.List;

import com.mossonthetree.gid.model.User;

@Repository
public class UserRepository {
	@PersistenceContext
	private EntityManager em;

	public User insert(User value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("insertUser");
		q.setParameter("first_name", value.getFirstName());
		q.setParameter("last_name", value.getLastName());
		q.setParameter("email", value.getEmail());
		try {
			q.execute();
			return (User)q.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	public boolean delete(int value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("deleteUser");
		q.setParameter("user_id", value);
		try {
			q.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public User selectByPk(int value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectUser");
		q.setParameter("user_id", value);
		try {
			User result = (User)q.getSingleResult();
			return result;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public User selectByEmail(String value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectUsersByEmail");
		q.setParameter("email", value);
		try {
			User result = (User)q.getSingleResult();
			return result;
		} catch (NoResultException ex) {
			return null;
		}
	}


	public boolean update(User value) {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("updateUser");
		q.setParameter("user_id", value.getUserId());
		q.setParameter("first_name", value.getFirstName());
		q.setParameter("last_name", value.getLastName());
		q.setParameter("email", value.getEmail());
		try {
			q.execute();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public List<User> selectAll() {
		StoredProcedureQuery q = em.createNamedStoredProcedureQuery("selectAllUsers");
		List<User> result = (List<User>)q.getResultList();
		return result;
	}

}
