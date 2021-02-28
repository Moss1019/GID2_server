package com.mossonthetree.gid.model;

import javax.persistence.*;

import java.util.Date;

import java.io.Serializable;

@Entity
@Table(name = "item")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
	name = "selectAllItems",
	procedureName = "sp_selectAllItems",
	resultClasses = Item.class),
@NamedStoredProcedureQuery(
	name = "selectItem",
	procedureName = "sp_selectItem",
	resultClasses = Item.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id")
	}
),
@NamedStoredProcedureQuery(
	name = "selectItemsByTitle",
	procedureName = "sp_selectItemsByTitle",
	resultClasses = Item.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "title")
	}
),
@NamedStoredProcedureQuery(
	name = "updateItem",
	procedureName = "sp_updateItem",
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "title"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "user_id")
	}
),
@NamedStoredProcedureQuery(
	name = "deleteItem",
	procedureName = "sp_deleteItem",
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "item_id")
	}
),
@NamedStoredProcedureQuery(
	name = "selectUserItems",
	procedureName = "sp_selectUserItems",
	resultClasses = Item.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "user_id")
	}
),
@NamedStoredProcedureQuery(
	name = "insertItem",
	procedureName = "sp_insertItem",
	resultClasses = Item.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "title"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "user_id")
	}
),
})
public class Item {
	@Id
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "title")
	private String title;
	@Column(name = "user_id")
	private int userId;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
