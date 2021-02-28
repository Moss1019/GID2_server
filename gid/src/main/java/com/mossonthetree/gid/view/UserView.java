package com.mossonthetree.gid.view;


import java.util.List;

public class UserView {
	private int userId;

	private String firstName;

	private String lastName;

	private String email;

	private List<ItemView> items;

	public UserView(int userId, String firstName, String lastName, String email, List<ItemView> items) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.items = items;
	}

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

	public List<ItemView> getItems() {
		return items;
	}

	public void setItems(List<ItemView> items) {
		this.items = items;
	}

}
