package com.mossonthetree.gid.view;


import java.util.List;

public class MilestoneView {
	private int milestoneId;

	private String description;

	private int itemId;

	public MilestoneView(int milestoneId, String description, int itemId) {
		this.milestoneId = milestoneId;
		this.description = description;
		this.itemId = itemId;
	}

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
