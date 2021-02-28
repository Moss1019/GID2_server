package com.mossonthetree.gid.model;

import javax.persistence.*;

import java.util.Date;

import java.io.Serializable;

@Entity
@Table(name = "milestone")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
	name = "selectAllMilestones",
	procedureName = "sp_selectAllMilestones",
	resultClasses = Milestone.class),
@NamedStoredProcedureQuery(
	name = "selectMilestone",
	procedureName = "sp_selectMilestone",
	resultClasses = Milestone.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "milestone_id")
	}
),
@NamedStoredProcedureQuery(
	name = "updateMilestone",
	procedureName = "sp_updateMilestone",
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "milestone_id"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "description"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id")
	}
),
@NamedStoredProcedureQuery(
	name = "deleteMilestone",
	procedureName = "sp_deleteMilestone",
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "milestone_id")
	}
),
@NamedStoredProcedureQuery(
	name = "selectItemMilestones",
	procedureName = "sp_selectItemMilestones",
	resultClasses = Milestone.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id")
	}
),
@NamedStoredProcedureQuery(
	name = "insertMilestone",
	procedureName = "sp_insertMilestone",
	resultClasses = Milestone.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "description"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id")
	}
),
})
public class Milestone {
	@Id
	@Column(name = "milestone_id")
	private int milestoneId;
	@Column(name = "description")
	private String description;
	@Column(name = "item_id")
	private int itemId;

	public int getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
