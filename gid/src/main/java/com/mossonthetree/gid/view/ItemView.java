package com.mossonthetree.gid.view;


import java.util.List;

public class ItemView {
	private int itemId;

	private String title;

	private int userId;

	private List<MilestoneView> milestones;

	public ItemView(int itemId, String title, int userId, List<MilestoneView> milestones) {
		this.itemId = itemId;
		this.title = title;
		this.userId = userId;
		this.milestones = milestones;
	}

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

	public List<MilestoneView> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<MilestoneView> milestones) {
		this.milestones = milestones;
	}

}
