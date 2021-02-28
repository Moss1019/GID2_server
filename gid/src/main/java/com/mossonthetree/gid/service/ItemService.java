package com.mossonthetree.gid.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mossonthetree.gid.model.Item;
import com.mossonthetree.gid.view.ItemView;
import com.mossonthetree.gid.repository.ItemRepository;
import com.mossonthetree.gid.mapper.ItemMapper;
import com.mossonthetree.gid.view.MilestoneView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
	@Autowired
	private ItemRepository repo;
	@Autowired
	private MilestoneService milestoneService;

	public ItemView insert(ItemView newItem) { 
		Item dbResult = repo.insert(ItemMapper.mapItemView(newItem));
		List<MilestoneView> milestoneViews = milestoneService.selectOfItem(dbResult.getItemId());
		ItemView result = ItemMapper.mapItem(dbResult, milestoneViews);
		return result;
	}

	public List<ItemView> selectOfUser(int userId) {
		List<Item> dbResult = repo.selectOfUser(userId);
		List<ItemView> result = dbResult.stream()
			.map(x -> {
				List<MilestoneView> milestoneViews = milestoneService.selectOfItem(x.getItemId());
				return ItemMapper.mapItem(x, milestoneViews);
			})
			.collect(Collectors.toList());
		return result;
	}

	public boolean delete(int id) {
		boolean result = repo.delete(id);
		return result;
	}

	public ItemView selectByPk(int value) {
		Item dbResult = repo.selectByPk(value);
		List<MilestoneView> milestones = milestoneService.selectOfItem(dbResult.getItemId());
		ItemView result = ItemMapper.mapItem(dbResult, milestones);
		return result;
	}

	public List<ItemView> selectAll() {
		List<Item> dbResult = repo.selectAll();
		List<ItemView> result = dbResult
			.stream()
			.map(x -> {
				List<MilestoneView> milestoneViews = milestoneService.selectOfItem(x.getItemId());
				return ItemMapper.mapItem(x, milestoneViews);
			})
			.collect(Collectors.toList());
		return result;
	}

	public ItemView selectByTitle(String value) {
		Item dbResult = repo.selectByTitle(value);
		List<MilestoneView> milestones = milestoneService.selectOfItem(dbResult.getItemId());
		ItemView result = ItemMapper.mapItem(dbResult, milestones);
		return result;
	}


	public boolean update(ItemView updatedItem) { 
		boolean result = repo.update(ItemMapper.mapItemView(updatedItem));
		return result;
	}

}
