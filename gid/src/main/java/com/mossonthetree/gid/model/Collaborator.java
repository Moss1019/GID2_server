package com.mossonthetree.gid.model;

import javax.persistence.*;

import java.util.Date;

import java.io.Serializable;

@Entity
@IdClass(Collaborator.CollaboratorPK.class)
@Table(name = "collaborator")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
	name = "deleteCollaborator",
	procedureName = "sp_deleteCollaborator",
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "user_id"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id")
	}
),
@NamedStoredProcedureQuery(
	name = "selectCollaborators",
	procedureName = "sp_selectCollaborators",
	resultClasses = User.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id")
	}
),
@NamedStoredProcedureQuery(
	name = "insertCollaborator",
	procedureName = "sp_insertCollaborator",
	resultClasses = Collaborator.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "user_id"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id")
	}
),
})
public class Collaborator {
	@Id
	@Column(name = "user_id")
	private int userId;
	@Id
	@Column(name = "item_id")
	private int itemId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public static class CollaboratorPK implements Serializable {
		protected int userId;
		protected int itemId;

		public CollaboratorPK() {
		}

		public CollaboratorPK(int userId, int itemId) {
			this.userId = userId;
			this.itemId = itemId;
		}
	}
}
