package com.mossonthetree.gid.model;

import javax.persistence.*;

import java.util.Date;

import java.io.Serializable;

@Entity
@Table(name = "user")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
	name = "selectAllUsers",
	procedureName = "sp_selectAllUsers",
	resultClasses = User.class),
@NamedStoredProcedureQuery(
	name = "selectUser",
	procedureName = "sp_selectUser",
	resultClasses = User.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "user_id")
	}
),
@NamedStoredProcedureQuery(
	name = "selectUsersByEmail",
	procedureName = "sp_selectUsersByEmail",
	resultClasses = User.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "email")
	}
),
@NamedStoredProcedureQuery(
	name = "updateUser",
	procedureName = "sp_updateUser",
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "user_id"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "first_name"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "last_name"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "email")
	}
),
@NamedStoredProcedureQuery(
	name = "deleteUser",
	procedureName = "sp_deleteUser",
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = Integer.class,
		name = "user_id")
	}
),
@NamedStoredProcedureQuery(
	name = "insertUser",
	procedureName = "sp_insertUser",
	resultClasses = User.class,
	parameters = {
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "first_name"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "last_name"),
	@StoredProcedureParameter(
		mode = ParameterMode.IN,
		type = String.class,
		name = "email")
	}
),
})
public class User {
	@Id
	@Column(name = "user_id")
	private int userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
