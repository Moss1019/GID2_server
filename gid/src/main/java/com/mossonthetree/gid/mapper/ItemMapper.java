package com.mossonthetree.gid.mapper;

import com.mossonthetree.gid.model.Item;
import com.mossonthetree.gid.view.ItemView;

import com.mossonthetree.gid.view.MilestoneView;

import java.util.List;

public class ItemMapper {
	public static ItemView mapItem(Item item, List<MilestoneView> milestones) {
		return new ItemView(item.getItemId(), item.getTitle(), item.getUserId(), milestones);
	}

	public static Item mapItemView(ItemView itemView) {
		Item item = new Item();
		item.setItemId(itemView.getItemId());
		item.setTitle(itemView.getTitle());
		item.setUserId(itemView.getUserId());
		return item;
	}
}
