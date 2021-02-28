package com.mossonthetree.gid.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mossonthetree.gid.model.Milestone;
import com.mossonthetree.gid.view.MilestoneView;
import com.mossonthetree.gid.repository.MilestoneRepository;
import com.mossonthetree.gid.mapper.MilestoneMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MilestoneService {
	@Autowired
	private MilestoneRepository repo;

	public MilestoneView insert(MilestoneView newMilestone) { 
		Milestone dbResult = repo.insert(MilestoneMapper.mapMilestoneView(newMilestone));
		MilestoneView result = MilestoneMapper.mapMilestone(dbResult);
		return result;
	}

	public List<MilestoneView> selectOfItem(int itemId) {
		List<Milestone> dbResult = repo.selectOfItem(itemId);
		List<MilestoneView> result = dbResult.stream()
			.map(x -> {
				return MilestoneMapper.mapMilestone(x);
			})
			.collect(Collectors.toList());
		return result;
	}

	public boolean delete(int id) {
		boolean result = repo.delete(id);
		return result;
	}

	public MilestoneView selectByPk(int value) {
		Milestone dbResult = repo.selectByPk(value);
		MilestoneView result = MilestoneMapper.mapMilestone(dbResult);
		return result;
	}

	public List<MilestoneView> selectAll() {
		List<Milestone> dbResult = repo.selectAll();
		List<MilestoneView> result = dbResult
			.stream()
			.map(x -> {
				return MilestoneMapper.mapMilestone(x);
			})
			.collect(Collectors.toList());
		return result;
	}


	public boolean update(MilestoneView updatedMilestone) { 
		boolean result = repo.update(MilestoneMapper.mapMilestoneView(updatedMilestone));
		return result;
	}

}
