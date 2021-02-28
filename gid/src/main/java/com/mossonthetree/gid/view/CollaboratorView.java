package com.mossonthetree.gid.view;


import java.util.List;

public class CollaboratorView {
	private int userId;

	private int itemId;

	public CollaboratorView(int userId, int itemId) {
		this.userId = userId;
		this.itemId = itemId;
	}

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

}
