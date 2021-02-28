package com.mossonthetree.gid.mapper;

import com.mossonthetree.gid.model.Milestone;
import com.mossonthetree.gid.view.MilestoneView;

import java.util.List;

public class MilestoneMapper {
	public static MilestoneView mapMilestone(Milestone milestone) {
		return new MilestoneView(milestone.getMilestoneId(), milestone.getDescription(), milestone.getItemId());
	}

	public static Milestone mapMilestoneView(MilestoneView milestoneView) {
		Milestone milestone = new Milestone();
		milestone.setMilestoneId(milestoneView.getMilestoneId());
		milestone.setDescription(milestoneView.getDescription());
		milestone.setItemId(milestoneView.getItemId());
		return milestone;
	}
}
